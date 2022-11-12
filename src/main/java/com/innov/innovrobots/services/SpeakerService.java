package com.innov.innovrobots.services;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Speaker;

import java.util.List;

public interface SpeakerService {

    List<Speaker> getSpeakers();
    Speaker getSpeakerById(Long id) throws NotFoundException;
    void saveSpeaker(Speaker speaker);
    void deleteSpeaker(Long id) throws NotFoundException;

    List<Speaker> getSpeakersByEventId(Long id);
}
