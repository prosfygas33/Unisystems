package com.example.Unisystems.Company;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    private CompanyMapper companyMapper;
    private CompanyRepository companyRepository;

    public CompanyService(CompanyMapper companyMapper, CompanyRepository companyRepository) {
        this.companyMapper = companyMapper;
        this.companyRepository = companyRepository;
    }


    public List<CompanyResponse> getCompanies(){
        Iterable<Company> retrievedCompanies = companyRepository.findAll();
        List<CompanyResponse> companies = new ArrayList<>();

        for ( Company company : retrievedCompanies ){
            companies.add(companyMapper.mapCompanyResponseFromCompany(company));
        }
        return companies;
    }

}
