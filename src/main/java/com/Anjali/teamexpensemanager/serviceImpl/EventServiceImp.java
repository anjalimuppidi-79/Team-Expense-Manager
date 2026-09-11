package com.Anjali.teamexpensemanager.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Anjali.teamexpensemanager.dto.EventRequest;
import com.Anjali.teamexpensemanager.entity.Event;
import com.Anjali.teamexpensemanager.entity.User;
import com.Anjali.teamexpensemanager.exceptions.ResourceNotFoundException;
import com.Anjali.teamexpensemanager.repository.EventRepository;
import com.Anjali.teamexpensemanager.repository.UserRepository;
import com.Anjali.teamexpensemanager.service.EventService;

@Service
public class EventServiceImp implements EventService {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public Event createEvent(EventRequest request) {
		Event event = new Event();

		event.setEventName(request.eventName());
		event.setLocation(request.location());

		return eventRepository.save(event);
	}

	@Override
	public List<Event> getAllEvents() {

		return eventRepository.findAll();
	}

	@Override
	public Event getEventById(Long id) {
		return eventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Event with ID " + id + " not found"));

	}

	@Override
	public Event addMember(Long eventId, Long userId) {
		Event event = getEventById(eventId);

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + " not found"));

		event.getMembers().add(user);

		return eventRepository.save(event);

	}

	@Override
	public Event removeMember(Long eventId, Long userId) {
		Event event = getEventById(eventId);

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + " not found"));

		event.getMembers().remove(user);

		return eventRepository.save(event);

	}

}
