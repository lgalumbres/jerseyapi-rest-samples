package lem.org.jersey.jaxb.client;

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

      URI uriBuilder = UriBuilder.fromUri("http://localhost:8080/samplerestjaxb").build();
      WebResource service = client.resource(uriBuilder);
      
      // Fluent interfaces
      System.out.println(service.path("rest").path("message").accept(MediaType.TEXT_XML).get(ClientResponse.class).toString());
      // Get XML
      System.out.println(service.path("rest").path("message").accept(MediaType.APPLICATION_XML).get(String.class));
      // Get JSON
      System.out.println(service.path("rest").path("message").accept(MediaType.APPLICATION_JSON).get(String.class));
   }

}
