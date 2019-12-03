package com.example.Unisystems.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/companies")
    public GetAllCompanies getAllCompanies(){
        return new GetAllCompanies(companyService.getCompanies());
    }

   }
