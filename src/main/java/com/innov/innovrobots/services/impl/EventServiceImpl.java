package com.innov.innovrobots.services.impl;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Event;
import com.innov.innovrobots.repositories.EventRepository;
import com.innov.innovrobots.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getEvents() {
        return this.eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long id) throws NotFoundException {
        if(this.eventRepository.findById(id).isPresent()) {
            return this.eventRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void saveEvent(Event event) {
        this.eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) throws NotFoundException {
        if(this.eventRepository.existsById(id)) {
            this.eventRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void activateEvent(Long id) throws NotFoundException {
        Event event = this.getEventById(id);
        List<Event> events = this.eventRepository.findAll();
        for( Event e : events)
            e.setStatus(false);
        this.eventRepository.saveAll(events);
        event.setStatus(true);
        this.eventRepository.save(event);
    }

    @Override
    public Event getActivatedEvent() throws NotFoundException {
        return this.eventRepository.findByStatusTrue();
    }
}
