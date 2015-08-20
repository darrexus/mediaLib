package org.darrexus.webapp.mediaLib.service;

import java.util.ArrayList;
import java.util.Calendar;
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
	}
	
	//Filtering by Year
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				messagesForYear.add(message)
;			}
		}
		return messagesForYear;
	}
	
	//Pagination method
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start + size > list.size())
			return new ArrayList<Message>();
		
		return list.subList(start, start + size);
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
