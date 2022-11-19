package com.innov.innovrobots.controllers;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Event;
import com.innov.innovrobots.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return eventService.getEventById(id);
    }

    @GetMapping("/activated")
    public Event getActivatedEvent() throws NotFoundException {
        return eventService.getActivatedEvent();
    }

    @PostMapping("/")
    public void saveEvent(@RequestBody Event event){
        eventService.saveEvent(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable(name = "id") Long id) throws NotFoundException {
        eventService.deleteEvent(id);
    }

    @PutMapping("/{id}")
    public void activateEvent(@PathVariable(name = "id") Long id) throws NotFoundException {
        eventService.activateEvent(id);
    }

    @PostMapping("/logo/{id}")
    public void saveLogo(@PathVariable(name = "id") Long id, @RequestParam(name = "logo_file") MultipartFile logo_file) throws Exception {
        eventService.saveLogo(id, logo_file);
    }

    @DeleteMapping("/logo/{id}")
    public void deleteLogo(@PathVariable(name = "id") Long id) throws NotFoundException {
        eventService.deleteLogo(id);
    }

    @PostMapping("/banner/{id}")
    public void saveBanner(@PathVariable(name = "id") Long id, @RequestParam(name = "banner_file") MultipartFile banner_file) throws Exception {
        eventService.saveBanner(id, banner_file);
    }

    @DeleteMapping("/banner/{id}")
    public void deleteBanner(@PathVariable(name = "id") Long id) throws NotFoundException {
        eventService.deleteBanner(id);
    }

    @PostMapping("/poster/{id}")
    public void savePoster(@PathVariable(name = "id") Long id, @RequestParam(name = "poster_file") MultipartFile poster_file) throws Exception {
        eventService.savePoster(id, poster_file);
    }

    @DeleteMapping("/poster/{id}")
    public void deletePoster(@PathVariable(name = "id") Long id) throws NotFoundException {
        eventService.deletePoster(id);
    }

    @PostMapping("/teaser/{id}")
    public Map<String, String> saveTeaser(@PathVariable(name = "id") Long id, @RequestBody String link) throws NotFoundException {
        return new HashMap<String, String>() {{
            put("link", eventService.saveTeaser(id, link));
        }};
    }

    @DeleteMapping("/teaser/{id}")
    public void resetTeaser(@PathVariable(name = "id") Long id) throws NotFoundException {
        eventService.resetTeaser(id);
    }

    @PostMapping("/liveStream/{id}")
    public Map<String, String> saveLiveStream(@PathVariable(name = "id") Long id, @RequestBody String link) throws NotFoundException {
        return new HashMap<String, String>() {{
            put("link", eventService.saveLiveStream(id, link));
        }};
    }

    @DeleteMapping("/liveStream/{id}")
    public void resetLiveStream(@PathVariable(name = "id") Long id) throws NotFoundException {
        eventService.resetLiveStream(id);
    }

}
