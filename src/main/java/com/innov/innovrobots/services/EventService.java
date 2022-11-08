package com.innov.innovrobots.services;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Event;

import java.util.List;

public interface EventService {

    List<Event> getEvents();
    Event getEventById(Long id) throws NotFoundException;
    void saveEvent(Event event);
    void deleteEvent(Long id) throws NotFoundException;
}
