package lem.org.jersey.crud.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import lem.org.jersey.crud.dao.MessageDAO;
import lem.org.jersey.crud.model.Message;

@Path("/messages")
public class MessagesResource {
   // Allows to insert contextual objects into the class, 
   // e.g. ServletContext, Request, Response, UriInfo
   @Context
   UriInfo uriInfo;
   @Context
   Request request;
   
   // Return the list of messages to the user in the browser
   @GET
   @Produces(MediaType.TEXT_XML)
   public List<Message> getMessagesBrowser() {
      List<Message> messages = new ArrayList<Message>();
      messages.addAll(MessageDAO.instance.getMessages().values());
      return messages;
   }
   
   // Return the list of messages for applications
   @GET
   @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public List<Message> getMessages() {
      List<Message> messages = new ArrayList<Message>();
      messages.addAll(MessageDAO.instance.getMessages().values());
      return messages;
   }
   
   // Get number of messages
   @GET
   @Path("count")
   @Produces(MediaType.TEXT_PLAIN)
   public String getMessagesCount() {
      int count = MessageDAO.instance.getMessages().size();
      return String.valueOf(count);
   }
   
   @POST
   @Produces(MediaType.TEXT_HTML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public void newMessage(
         @FormParam("id") String id, 
         @FormParam("to") String to, 
         @FormParam("from") String from, 
         @FormParam("subject") String subject, 
         @FormParam("body") String body,
         @Context HttpServletResponse response) throws IOException {
      Message message = new Message(id, to, from, subject, body);
      MessageDAO.instance.getMessages().put(id, message);
      
      response.sendRedirect("../create_message.html");
   }
   
   // Defines the new path parameter after messages is treated as a parameter and passed to the MessagesResources.
   // Allows to type http://localhost:8080/samplerestcrud/rest/messages/1 where 1 will be treated as a parameter
   // message and passed to MessageResource.
   @Path("{message}")
   public MessageResource getMessage(@PathParam("message") String id) {
      return new MessageResource(uriInfo, request, id);
   }
}
