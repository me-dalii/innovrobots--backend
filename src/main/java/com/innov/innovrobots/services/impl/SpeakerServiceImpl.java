package com.innov.innovrobots.services.impl;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Speaker;
import com.innov.innovrobots.repositories.SpeakerRepository;
import com.innov.innovrobots.services.SpeakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerRepository speakerRepository;

    @Override
    public List<Speaker> getSpeakers() {
        return this.speakerRepository.findAll();
    }

    @Override
    public Speaker getSpeakerById(Long id) throws NotFoundException {
        if(this.speakerRepository.findById(id).isPresent()) {
            return this.speakerRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void saveSpeaker(Speaker speaker) {
        this.speakerRepository.save(speaker);
    }

    @Override
    public void deleteSpeaker(Long id) throws NotFoundException {
        if(this.speakerRepository.existsById(id)) {
            this.speakerRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public List<Speaker> getSpeakersByEventId(Long id) {
        return this.speakerRepository.findAllByEventId(id);
    }
}
