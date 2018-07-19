package pt.noshio.restjava;

/**
 * Demonstration project for
 * -JAX-RS
 * -CDI  
 * with Java SE
 * 
 */

public class App {
	private static final int INET_PORT = 8080;
	
	
	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		Server server=new Server();
		server.start(INET_PORT);
	}

}