package com.innov.innovrobots.controllers;

import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Committee;
import com.innov.innovrobots.models.Speaker;
import com.innov.innovrobots.services.CommitteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/committee")
public class CommitteeController {
    @Autowired
    private CommitteeService committeeService;

    @GetMapping("/")
    public List<Committee> getCommittees(){
        return committeeService.getCommittees();
    }

    @GetMapping("/{id}")
    public Committee getCommitteeById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return committeeService.getCommitteeById(id);
    }

    @PostMapping("/")
    public void saveCommittee(@RequestBody Committee committee){
        committeeService.saveCommittee(committee);
    }

    @DeleteMapping("/{id}")
    public void deleteCommittee(@PathVariable(name = "id") Long id) throws NotFoundException {
        committeeService.deleteCommittee(id);
    }

    @GetMapping("/event/{id}")
    public List<Committee> getCommitteesByEventId(@PathVariable(name = "id") Long id) throws NotFoundException {
        return committeeService.getCommitteesByEventId(id);
    }
}
