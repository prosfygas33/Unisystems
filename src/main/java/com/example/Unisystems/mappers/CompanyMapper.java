package com.example.Unisystems.mappers;

import com.example.Unisystems.model.Company;
import com.example.Unisystems.model.CompanyResponse;
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
