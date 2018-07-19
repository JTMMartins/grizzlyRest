package pt.noshio.restjava;

import javax.ws.rs.ext.RuntimeDelegate;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;
import org.jboss.weld.environment.se.Weld;


public class Server {



	public void start(int portNumber) {
		Weld weld = new Weld();
		weld.initialize(); //The weld container will be initialized
		
		RestApplication restApplication = new RestApplication();
		ResourceConfig resourceConfig = ResourceConfig.forApplication(restApplication);
		HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(resourceConfig, HttpHandler.class);
		HttpServer server = HttpServer.createSimpleServer(null, portNumber);
		server.getServerConfiguration().addHttpHandler(handler);

		try {
			server.start();
			System.out.println("any key to stop server...");
			System.in.read();
			server.shutdown();
			weld.shutdown();

		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
