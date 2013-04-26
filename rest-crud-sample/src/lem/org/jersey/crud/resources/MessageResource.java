package lem.org.jersey.crud.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import lem.org.jersey.crud.dao.MessageDAO;
import lem.org.jersey.crud.model.Message;

public class MessageResource {
   @Context
   private UriInfo uriInfo = null;
   @Context
   private Request request = null;
   private String id = null;
   
   public MessageResource(UriInfo uriInfo, Request request, String id) {
      this.uriInfo = uriInfo;
      this.request = request;
      this.id = id;
   }
   
   @GET
   @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public Message getMessage() {
      Message message = MessageDAO.instance.getMessages().get(id);
      if (message == null) {
         throw new RuntimeException("GET: Message with " + id + " not found.");
      }
      return message;
   }
   
   @GET
   @Produces(MediaType.TEXT_XML)
   public Message getMessageHTML() {
      Message message = MessageDAO.instance.getMessages().get(id);
      if (message == null) {
         throw new RuntimeException("GET: Message with " + id + " not found.");
      }
      return message;
   }
   
   @PUT
   @Consumes(MediaType.APPLICATION_XML)
   public Response putMessage(JAXBElement<Message> message) {
      Message m = message.getValue();
      return putAndGetResponse(m);
   }
   
   @DELETE
   public void deleteMessage() {
      Message message = MessageDAO.instance.getMessages().get(id);
      if (message == null) {
         throw new RuntimeException("DELETE: Message with " + id + " not found.");
      }
   }
   
   private Response putAndGetResponse(Message message) {
      Response res = null;
      if (MessageDAO.instance.getMessages().containsKey(message.getId())) {
         res = Response.noContent().build();
      }
      else {
         res = Response.created(uriInfo.getAbsolutePath()).build();
      }
      MessageDAO.instance.getMessages().put(message.getId(), message);
      return res;
   }
   
}
