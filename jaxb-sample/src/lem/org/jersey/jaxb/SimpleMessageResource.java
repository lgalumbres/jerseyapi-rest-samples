package lem.org.jersey.jaxb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message")
public class SimpleMessageResource {
   @GET
   @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
   public SimpleMessage getXML() {
      SimpleMessage message = new SimpleMessage();
      
      message.setTo("Receiver");
      message.setFrom("Sender");
      message.setSubject("An XML Message");
      message.setBody("This is an XML Message.");
      
      return message;
   }

   @GET
   @Produces({ MediaType.TEXT_XML })
   public SimpleMessage getHTML() {
      SimpleMessage message = new SimpleMessage();
      
      message.setTo("Receiver");
      message.setFrom("Sender");
      message.setSubject("An HTML Message");
      message.setBody("This is an HTML Message.");
      
      return message;
   }
}
