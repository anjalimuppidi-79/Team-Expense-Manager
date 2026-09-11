package com.Anjali.teamexpensemanager.service;

import java.util.List;

import com.Anjali.teamexpensemanager.dto.EventRequest;
import com.Anjali.teamexpensemanager.entity.Event;

public interface EventService {

	public Event createEvent(EventRequest request);

	public List<Event> getAllEvents();

	public Event getEventById(Long id);

	public Event addMember(Long eventId, Long userId);

	public Event removeMember(Long eventId, Long userId);

}
