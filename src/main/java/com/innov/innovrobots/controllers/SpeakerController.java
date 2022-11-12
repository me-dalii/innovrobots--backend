package com.innov.innovrobots.controllers;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Committee;
import com.innov.innovrobots.models.Speaker;
import com.innov.innovrobots.services.CommitteeService;
import com.innov.innovrobots.services.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speaker")
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;

    @GetMapping("/")
    public List<Speaker> getSpeakers(){
        return speakerService.getSpeakers();
    }

    @GetMapping("/{id}")
    public Speaker getSpeakerById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return speakerService.getSpeakerById(id);
    }

    @PostMapping("/")
    public void saveSpeaker(@RequestBody Speaker speaker){
        speakerService.saveSpeaker(speaker);
    }

    @DeleteMapping("/{id}")
    public void deleteSpeaker(@PathVariable(name = "id") Long id) throws NotFoundException {
        speakerService.deleteSpeaker(id);
    }

    @GetMapping("/event/{id}")
    public List<Speaker> getSpeakersByEventId(@PathVariable(name = "id") Long id) throws NotFoundException {
        return speakerService.getSpeakersByEventId(id);
    }
}
