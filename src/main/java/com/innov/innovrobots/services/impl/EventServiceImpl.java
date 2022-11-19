package com.innov.innovrobots.services.impl;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.CustomFile;
import com.innov.innovrobots.models.Event;
import com.innov.innovrobots.repositories.CustomFileRepository;
import com.innov.innovrobots.repositories.EventRepository;
import com.innov.innovrobots.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    @Autowired
    private CustomFileRepository customFileRepository;

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

    @Override
    public void saveLogo(Long id, MultipartFile logo_file) throws Exception {
        Event event = this.getEventById(id);
        Long oldLogoId = null;
        if(event.getLogo() != null){
            oldLogoId = event.getLogo().getId();
        }

        if (logo_file != null) {
            String logo_fileName = StringUtils.cleanPath(logo_file.getOriginalFilename());
            CustomFile logo = new CustomFile(logo_fileName, Base64.getEncoder().encodeToString(logo_file.getBytes()));
            CustomFile savedLogo = this.customFileRepository.save(logo);
            event.setLogo(savedLogo);
        }

        this.eventRepository.save(event);

        if(oldLogoId != null){
            this.customFileRepository.deleteById(oldLogoId);
        }
    }

    @Override
    public void deleteLogo(Long id) throws NotFoundException {
        Event event = this.getEventById(id);

        Long oldLogoId = null;
        if(event.getLogo() != null){
            oldLogoId = event.getLogo().getId();
        }
        event.setLogo(null);
        this.eventRepository.save(event);
        if(oldLogoId != null){
            this.customFileRepository.deleteById(oldLogoId);
        }
    }

    @Override
    public void saveBanner(Long id, MultipartFile banner_file) throws Exception {
        Event event = this.getEventById(id);
        Long oldBannerId = null;
        if(event.getBanner() != null){
            oldBannerId = event.getBanner().getId();
        }

        if (banner_file != null) {
            String banner_fileName = StringUtils.cleanPath(banner_file.getOriginalFilename());
            CustomFile banner = new CustomFile(banner_fileName, Base64.getEncoder().encodeToString(banner_file.getBytes()));
            CustomFile savedBanner = this.customFileRepository.save(banner);
            event.setBanner(savedBanner);
        }

        this.eventRepository.save(event);

        if(oldBannerId != null){
            this.customFileRepository.deleteById(oldBannerId);
        }
    }

    @Override
    public void deleteBanner(Long id) throws NotFoundException {
        Event event = this.getEventById(id);

        Long oldBannerId = null;
        if(event.getBanner() != null){
            oldBannerId = event.getBanner().getId();
        }
        event.setBanner(null);
        this.eventRepository.save(event);
        if(oldBannerId != null){
            this.customFileRepository.deleteById(oldBannerId);
        }
    }

    @Override
    public void savePoster(Long id, MultipartFile poster_file) throws Exception {
        Event event = this.getEventById(id);
        Long oldPosterId = null;
        if(event.getPoster() != null){
            oldPosterId = event.getPoster().getId();
        }

        if (poster_file != null) {
            String poster_fileName = StringUtils.cleanPath(poster_file.getOriginalFilename());
            CustomFile poster = new CustomFile(poster_fileName, Base64.getEncoder().encodeToString(poster_file.getBytes()));
            CustomFile savedPoster = this.customFileRepository.save(poster);
            event.setPoster(savedPoster);
        }

        this.eventRepository.save(event);

        if(oldPosterId != null){
            this.customFileRepository.deleteById(oldPosterId);
        }
    }

    @Override
    public void deletePoster(Long id) throws NotFoundException {
        Event event = this.getEventById(id);

        Long oldPosterId = null;
        if(event.getPoster() != null){
            oldPosterId = event.getPoster().getId();
        }
        event.setPoster(null);
        this.eventRepository.save(event);
        if(oldPosterId != null){
            this.customFileRepository.deleteById(oldPosterId);
        }
    }

    @Override
    public String saveTeaser(Long id, String link) throws NotFoundException {
        Event event = this.getEventById(id);
        event.setYoutubeTeaserLink(link);
        event = this.eventRepository.save(event);
        return event.getYoutubeTeaserLink();
    }

    @Override
    public void resetTeaser(Long id) throws NotFoundException {
        Event event = this.getEventById(id);
        event.setYoutubeTeaserLink("");
        this.eventRepository.save(event);
    }

    @Override
    public String saveLiveStream(Long id, String link) throws NotFoundException {
        Event event = this.getEventById(id);
        event.setYoutubeLiveStreamLink(link);
        event = this.eventRepository.save(event);
        return event.getYoutubeTeaserLink();
    }

    @Override
    public void resetLiveStream(Long id) throws NotFoundException {
        Event event = this.getEventById(id);
        event.setYoutubeLiveStreamLink("");
        this.eventRepository.save(event);
    }


}
