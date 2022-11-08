package com.innov.innovrobots.services.impl;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Committee;
import com.innov.innovrobots.repositories.CommitteeRepository;
import com.innov.innovrobots.services.CommitteeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommitteeServiceImpl implements CommitteeService {

    @Autowired
    private CommitteeRepository committeeRepository;

    @Override
    public List<Committee> getCommittees() {
        return this.committeeRepository.findAll();
    }

    @Override
    public Committee getCommitteeById(Long id) throws NotFoundException {
        if(this.committeeRepository.findById(id).isPresent()) {
            return this.committeeRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void saveCommittee(Committee committee) {
        this.committeeRepository.save(committee);
    }

    @Override
    public void deleteCommittee(Long id) throws NotFoundException {
        if(this.committeeRepository.existsById(id)) {
            this.committeeRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }
}
