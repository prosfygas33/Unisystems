package com.example.Unisystems.Unit;

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

    public UnitService(UnitRepository unitRepository, UnitMapper unitMapper) {
        this.unitRepository = unitRepository;
        this.unitMapper = unitMapper;
    }

    public List<UnitResponse> getUnits(){
        Iterable<Unit> retrievedUnits = unitRepository.findAll();
        List<UnitResponse> units = new ArrayList<>();

        for ( Unit unit : retrievedUnits ){
            units.add(unitMapper.mapUnitResponseFromUnit(unit));
        }

        return units;
    }
}
