package com.example.Unisystems.Unit;

import com.example.Unisystems.Unit.Unit;
import com.example.Unisystems.Unit.UnitResponse;
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
