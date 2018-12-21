package com.johnwalkers.restwebservices.messenger.service;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.johnwalkers.restwebservices.messenger.database.DatabaseClass;
import com.johnwalkers.restwebservices.messenger.exception.DataNotFoundException;
import com.johnwalkers.restwebservices.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Hello World!", "John"));
		messages.put(2L, new Message(2, "Hello John!", "John"));

	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesForYear(int year) {
		Calendar cal = Calendar.getInstance();
		return messages.values().stream().filter(message -> {
			cal.setTime(message.getCreated());
			return cal.get(Calendar.YEAR) == year;
		}).collect(toList());
	}

	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) {
			return new ArrayList<Message>();
		}
		return list.subList(start, start + size);
	}

	public Message getMessage(long id) {
		Message message = messages.get(id);
		if(message == null) {
			throw new NullPointerException("Message with id " + id + " not found");
		}
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
