package com.jobapp.jobapp.Company.impl;

import com.jobapp.jobapp.Company.Company;
import com.jobapp.jobapp.Company.CompanyRepository;
import com.jobapp.jobapp.Company.CompanyService;
import com.jobapp.jobapp.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()) {
            Company companyToUpadte = companyOptional.get();
            companyToUpadte.setDescription(company.getDescription());
            companyToUpadte.setName(company.getName());
            companyToUpadte.setJobs(company.getJobs());

            // Persist changes
            companyRepository.save(companyToUpadte);

            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
