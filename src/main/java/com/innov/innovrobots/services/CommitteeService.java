package com.innov.innovrobots.services;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Committee;

import java.util.List;

public interface CommitteeService {

    List<Committee> getCommittees();
    Committee getCommitteeById(Long id) throws NotFoundException;
    void saveCommittee(Committee committee);
    void deleteCommittee(Long id) throws NotFoundException;
}
