package lem.org.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/HelloWorld")
public class HelloWorld {
   
   /**
    * A plain text request
    * @return
    */
   @GET
   @Produces(MediaType.TEXT_PLAIN)
   public String sayPlainTextHello() {
      System.out.println("sayPlainTextHello();");
      return "Hello World";
   }
   
   /**
    * A xml request
    * @return
    */
   @GET
   @Produces(MediaType.TEXT_XML)
   public String sayXMLHello() {
      System.out.println("sayXMLHello();");
      return "<?xml version=\"1.0\"?>" + "<hello>Hello</hello><world>World</world>";
   }

   /**
    * A html request
    * @return
    */
   @GET
   @Produces(MediaType.TEXT_HTML)
   public String sayHTMLHello() {
      System.out.println("sayHTMLHello();");
      return "<html><title>Hello World</title><body><h1>Hello World<h1></body></html>";
   }
}
