package pt.noshio.restjava;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

				public void run() {
					server.shutdown();
					weld.shutdown();
				}
			}));

			System.out.println(String.format("Grizzly Http server started.\nTerminate with " + "CTRL+C."));
			Thread.currentThread().join();
		} catch (InterruptedException | IOException ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
		}



