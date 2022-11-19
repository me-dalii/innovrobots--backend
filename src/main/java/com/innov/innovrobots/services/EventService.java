package com.innov.innovrobots.services;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Event;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EventService {

    List<Event> getEvents();
    Event getEventById(Long id) throws NotFoundException;
    void saveEvent(Event event);
    void deleteEvent(Long id) throws NotFoundException;
    void activateEvent(Long id) throws NotFoundException;
    Event getActivatedEvent() throws NotFoundException;

    void saveLogo(Long id, MultipartFile logo_file) throws Exception;
    void deleteLogo(Long id) throws NotFoundException;
    void saveBanner(Long id, MultipartFile banner_file) throws Exception;
    void deleteBanner(Long id) throws NotFoundException;
    void savePoster(Long id, MultipartFile poster_file) throws Exception;
    void deletePoster(Long id) throws NotFoundException;

    String saveTeaser(Long id, String link) throws NotFoundException;
    void resetTeaser(Long id) throws NotFoundException;

    void resetLiveStream(Long id) throws NotFoundException;
    String saveLiveStream(Long id, String link) throws NotFoundException;
}
