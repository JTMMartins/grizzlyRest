package pt.noshio.restjava;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("/")
public class RestApplication extends ResourceConfig {
	
	public RestApplication() {
		// classes in this package will be scanned
		// for resources (endpoints)
		packages("pt.noshio.endpoints");
		property(ServerProperties.TRACING,"ALL");
	}
}
