package com.example.Unisystems.model;

import java.util.List;

public class GetAllCompanies {

    private List<CompanyResponse> companies;

    public GetAllCompanies(List<CompanyResponse> companies) {
        this.companies = companies;
    }

    public List<CompanyResponse> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompanyResponse> companies) {
        this.companies = companies;
    }
}
