package com.innov.innovrobots.controllers;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Sponsor;
import com.innov.innovrobots.services.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sponsor")
public class SponsorController {

    @Autowired
    private SponsorService sponsorService;

    @GetMapping("/")
    public List<Sponsor> getSponsors(){
        return sponsorService.getSponsors();
    }

    @GetMapping("/{id}")
    public Sponsor getSponsorById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return sponsorService.getSponsorById(id);
    }

    @PostMapping("/")
    public void saveSponsor(@RequestBody Sponsor sponsor){
        sponsorService.saveSponsor(sponsor);
    }

    @DeleteMapping("/{id}")
    public void deleteSponsor(@PathVariable(name = "id") Long id) throws NotFoundException {
        sponsorService.deleteSponsor(id);
    }

    @GetMapping("/event/{id}")
    public List<Sponsor> getSponsorsByEventId(@PathVariable(name = "id") Long id) throws NotFoundException {
        return sponsorService.getSponsorsByEventId(id);
    }
}
