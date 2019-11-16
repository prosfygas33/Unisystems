package com.example.Unisystems.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyRepository companyRepository;

    public List<CompanyResponse> getCompanies(){
        Iterable<Company> retrievedCompanies = companyRepository.findAll();
        List<CompanyResponse> companies = new ArrayList<>();

        for ( Company company : retrievedCompanies ){
            companies.add(companyMapper.mapCompanyResponseFromCompany(company));
        }

        return companies;
    }

}
