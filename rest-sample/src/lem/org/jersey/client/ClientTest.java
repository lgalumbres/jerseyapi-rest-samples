package lem.org.jersey.client;

import java.net.URI;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ClientTest {

   public static void main(String[] args) {
      ClientConfig config = new DefaultClientConfig();
      Client client = Client.create(config);

      URI uriBuilder = UriBuilder.fromUri("http://localhost:8080/samplerest").build();
      WebResource service = client.resource(uriBuilder);
      
      // Fluent interfaces
      System.out.println(service.path("rest").path("HelloWorld").accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString());
      // Get plain text
      System.out.println(service.path("rest").path("HelloWorld").accept(MediaType.TEXT_PLAIN).get(String.class));
      // Get XML
      System.out.println(service.path("rest").path("HelloWorld").accept(MediaType.TEXT_XML).get(String.class));
      // The HTML
      System.out.println(service.path("rest").path("HelloWorld").accept(MediaType.TEXT_HTML).get(String.class));
   }

}
