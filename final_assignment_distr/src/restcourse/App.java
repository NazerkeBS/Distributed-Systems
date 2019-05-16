package restcourse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.InetAddress;

import com.sun.net.httpserver.HttpServer;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import utils.*;

public class App {
	public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException
    {
		URI BASE_URI = UriBuilder.fromUri("http://localhost/").port(9998).build();
		//ResourceConfig config = new ResourceConfig(MyResource.class);
		HttpServer server = JdkHttpServerFactory.createHttpServer(BASE_URI, createApp());

        System.out.println("Starting sdelab standalone HTTP server...");
				//JdkHttpServerFactory.createHttpServer(BASE_URI, createApp());
        System.out.println("Server started on " + BASE_URI + "\n[kill the process to exit]");

		JsonExample.listSpecies();
    }

    public static ResourceConfig createApp() {
        System.out.println("Authentication services are running...");
        return new AppConfig();
    }
}
