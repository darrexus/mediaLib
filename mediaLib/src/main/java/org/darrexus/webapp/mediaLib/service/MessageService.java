package org.darrexus.webapp.mediaLib.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.darrexus.webapp.mediaLib.database.DatabaseClass;
import org.darrexus.webapp.mediaLib.model.Message;


public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessage();
	
	public MessageService(){
		messages.put(1L , new Message(1, "message 1", "Dare"));
		messages.put(2L , new Message(2, "message 2", "Dare"));
		messages.put(3L , new Message(3, "Hello world", "Dare"));
		messages.put(4L , new Message(4, "Learn jersey", "Dare"));
		messages.put(5L , new Message(5, "message 5", "Dare"));
	}
	
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
		//Message m1 = new Message(1, "message 1", "Dare");
		//Message m2 = new Message(2, "message 2", "Dare");
		//Message m3 = new Message(3, "message 3", "Dare");
		//Message m4 = new Message(4, "message 4", "Dare");
		//Message m5 = new Message(5, "message 5", "Dare");		
		//List<Message> list = new ArrayList<>();
		//list.add(m1);
		//list.add(m2);
		//list.add(m3);
		//list.add(m4);
		//list.add(m5);		
		//return list;
	}
	//GET
	public Message getMessage(Long id){
		return messages.get(id);
	}
	//POST
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	//PUT
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);		
		return message;
	}
	//DELETE
	public Message removeMessage(Long id){
		return messages.remove(id);
	}

}
