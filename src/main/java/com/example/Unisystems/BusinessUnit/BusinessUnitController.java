package com.example.Unisystems.BusinessUnit;

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
