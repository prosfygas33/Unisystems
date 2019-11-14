package com.example.Unisystems.services;

import com.example.Unisystems.mappers.UnitMapper;
import com.example.Unisystems.model.Unit;
import com.example.Unisystems.model.UnitResponse;
import com.example.Unisystems.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitService {

    @Autowired
    UnitRepository unitRepository;

    @Autowired
    UnitMapper unitMapper;

    public List<UnitResponse> getUnits(){
        Iterable<Unit> retrievedUnits = unitRepository.findAll();
        List<UnitResponse> units = new ArrayList<>();

        for ( Unit unit : retrievedUnits ){
            units.add(unitMapper.mapUnitResponseFromUnit(unit));
        }

        return units;
    }
}
