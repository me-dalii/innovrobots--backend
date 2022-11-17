package com.innov.innovrobots.services.impl;

import com.innov.innovrobots.exceptions.FullCapacityException;
import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Company;
import com.innov.innovrobots.models.Student;
import com.innov.innovrobots.repositories.CommitteeRepository;
import com.innov.innovrobots.repositories.CompanyRepository;
import com.innov.innovrobots.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getCompanies() {
        return this.companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) throws NotFoundException {
        if(this.companyRepository.findById(id).isPresent()) {
            return this.companyRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }


    @Override
    public void saveCompany(Company company) throws FullCapacityException {
        long savedCompaniesNumber =this.companyRepository.count();
        if (savedCompaniesNumber < company.getEvent().getNumberOfAllowedCompanies())
            this.companyRepository.save(company);
        else
            throw new FullCapacityException();
    }

    @Override
    public void deleteCompany(Long id) throws NotFoundException {
        if(this.companyRepository.existsById(id)) {
            this.companyRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public List<Company> getCompaniesByEventId(Long id) {
        return this.companyRepository.findAllByEventId(id);
    }
}
