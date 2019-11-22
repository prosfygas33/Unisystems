package com.example.Unisystems.BusinessUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessUnitController {

    @Autowired
    private BusinessUnitService businessUnitService;

    @GetMapping("/businessUnits")
    public ResponseEntity getBusinessUnits(){
        return new ResponseEntity(
                new GetAllBusinessUnits(businessUnitService.getBusinessUnits()),
                null,
                HttpStatus.OK
        );
    }
}
