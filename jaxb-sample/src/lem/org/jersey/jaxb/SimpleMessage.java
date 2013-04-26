package lem.org.jersey.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
public class SimpleMessage {
   private String to = null;
   private String from = null;
   private String subject = null;
   private String body = null;
   
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
