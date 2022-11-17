package com.innov.innovrobots.controllers;

import com.innov.innovrobots.exceptions.FullCapacityException;
import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Company;
import com.innov.innovrobots.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return companyService.getCompanyById(id);
    }

    @PostMapping("/")
    public void saveCompany(@RequestBody Company company) throws FullCapacityException {
        companyService.saveCompany(company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable(name = "id") Long id) throws NotFoundException {
        companyService.deleteCompany(id);
    }

    @GetMapping("/event/{id}")
    public List<Company> getCompaniesByEventId(@PathVariable(name = "id") Long id) throws NotFoundException {
        return companyService.getCompaniesByEventId(id);
    }
}
