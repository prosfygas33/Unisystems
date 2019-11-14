package com.example.Unisystems.controllers;

import com.example.Unisystems.model.GetAllBusinessUnits;
import com.example.Unisystems.services.BusinessUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessUnitController {

    @Autowired
    private BusinessUnitService businessUnitService;

    @GetMapping("/businessUnits")
    public GetAllBusinessUnits getBusinessUnits(){
        return new GetAllBusinessUnits(businessUnitService.getBusinessUnits());
    }
}
