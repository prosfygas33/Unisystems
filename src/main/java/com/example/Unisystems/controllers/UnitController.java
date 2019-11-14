package com.example.Unisystems.controllers;

import com.example.Unisystems.model.GetAllUnits;
import com.example.Unisystems.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitController {

    @Autowired
    UnitService unitService;

    @GetMapping("/Units")
    public GetAllUnits getAllUnits(){
        return new GetAllUnits(unitService.getUnits());
    }

}
