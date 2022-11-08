package com.innov.innovrobots.services;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Sponsor;

import java.util.List;

public interface SponsorService {
    List<Sponsor> getSponsors();
    Sponsor getSponsorById(Long id) throws NotFoundException;
    void saveSponsor(Sponsor sponsor);
    void deleteSponsor(Long id) throws NotFoundException;
}
