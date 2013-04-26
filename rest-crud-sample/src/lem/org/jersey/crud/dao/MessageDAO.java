package lem.org.jersey.crud.dao;

import java.util.Map;
import java.util.HashMap;

import lem.org.jersey.crud.model.Message;

public enum MessageDAO {
   instance;
   
   private Map<String, Message> messages = new HashMap<String, Message>();
   
   private MessageDAO() {
      Message message = new Message("1", "John", "Mary", "Hi John", "Hello John!");
      messages.put(message.getId(), message);
      message = new Message("2", "Kyle", "John", "Hi Kyle", "Hello Kyle!");
      messages.put(message.getId(), message);
      message = new Message("3", "Cameron", "Kyle", "Hi Cameron", "Hello Cameron!");
      messages.put(message.getId(), message);
   }
   
   public Map<String, Message> getMessages() {
      return messages;
   }
}
