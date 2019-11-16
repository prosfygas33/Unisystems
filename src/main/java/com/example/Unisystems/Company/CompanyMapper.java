package com.example.Unisystems.Company;

import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Company.CompanyResponse;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyResponse mapCompanyResponseFromCompany(Company company) {
        return new CompanyResponse(
                company.getId(),
                company.getName()
        );
    }
}
