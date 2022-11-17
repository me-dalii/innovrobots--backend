package com.innov.innovrobots.services;

import com.innov.innovrobots.exceptions.FullCapacityException;
import com.innov.innovrobots.exceptions.NotFoundException;
import com.innov.innovrobots.models.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getCompanies();
    Company getCompanyById(Long id) throws NotFoundException;
    void saveCompany(Company company) throws FullCapacityException;
    void deleteCompany(Long id) throws NotFoundException;

    List<Company> getCompaniesByEventId(Long id);
}
