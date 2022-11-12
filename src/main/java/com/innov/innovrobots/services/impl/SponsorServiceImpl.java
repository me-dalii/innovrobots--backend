package com.innov.innovrobots.services.impl;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Sponsor;
import com.innov.innovrobots.repositories.SponsorRepository;
import com.innov.innovrobots.services.SponsorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SponsorServiceImpl implements SponsorService {

    @Autowired
    private SponsorRepository sponsorRepository;


    @Override
    public List<Sponsor> getSponsors()  {
        return this.sponsorRepository.findAll();
    }


    @Override
    public Sponsor getSponsorById(Long id) throws NotFoundException {
        if(this.sponsorRepository.findById(id).isPresent()) {
            return this.sponsorRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void saveSponsor(Sponsor sponsor) {
        this.sponsorRepository.save(sponsor);
    }

    @Override
    public void deleteSponsor(Long id) throws NotFoundException {
        if(this.sponsorRepository.existsById(id)) {
            this.sponsorRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public List<Sponsor> getSponsorsByEventId(Long id) {
        return this.sponsorRepository.findAllByEventId(id);
    }
}
