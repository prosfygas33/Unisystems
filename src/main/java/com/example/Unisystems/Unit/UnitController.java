package com.example.Unisystems.Unit;

import com.example.Unisystems.Unit.GetAllUnits;
import com.example.Unisystems.Unit.UnitService;
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
