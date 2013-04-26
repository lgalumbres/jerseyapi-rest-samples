package lem.org.jersey.crud.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
   private String id = null;
   private String to = null;
   private String from = null;
   private String subject = null;
   private String body = null;
   
   // Default constructor
   public Message() {
   }
   
   public Message(String id, String to, String from, String subject, String body) {
      super();
      this.id = id;
      this.to = to;
      this.from = from;
      this.subject = subject;
      this.body = body;
   }

   public String getId() {
      return id;
   }
   
   public void setId(String id) {
      this.id = id;
   }
   
   public String getTo() {
      return to;
   }
   
   public void setTo(String to) {
      this.to = to;
   }
   
   public String getFrom() {
      return from;
   }
   
   public void setFrom(String from) {
      this.from = from;
   }
   
   public String getSubject() {
      return subject;
   }
   
   public void setSubject(String subject) {
      this.subject = subject;
   }
   
   public String getBody() {
      return body;
   }
   
   public void setBody(String body) {
      this.body = body;
   }
}
