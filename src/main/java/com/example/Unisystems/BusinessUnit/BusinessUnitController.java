package com.example.Unisystems.BusinessUnit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessUnitController {

    private BusinessUnitService businessUnitService;

    public BusinessUnitController(BusinessUnitService businessUnitService) {
        this.businessUnitService = businessUnitService;
    }

    @GetMapping("/businessUnits")
    public ResponseEntity getBusinessUnits(){
        return new ResponseEntity<>(businessUnitService.getBusinessUnits(),
                                    null,
                                    HttpStatus.OK);
    }
}
