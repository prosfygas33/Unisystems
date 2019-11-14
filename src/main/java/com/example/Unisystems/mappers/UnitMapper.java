package com.example.Unisystems.mappers;

import com.example.Unisystems.model.Unit;
import com.example.Unisystems.model.UnitResponse;
import org.springframework.stereotype.Component;

@Component
public class UnitMapper {

    public UnitResponse mapUnitResponseFromUnit(Unit unit){
        return new UnitResponse(
                unit.getId(),
                unit.getName(),
                unit.getDepartment()
        );
    }
}
