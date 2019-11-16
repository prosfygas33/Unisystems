package com.example.Unisystems.BusinessUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessUnitService {

    @Autowired
    BusinessUnitMapper businessUnitMapper;

    @Autowired
    BusinessUnitRepository businessUnitRepository;

    public List<BusinessUnitResponse> getBusinessUnits(){
        Iterable<BusinessUnit> retrievedBusinessUnits = businessUnitRepository.findAll();
        List<BusinessUnitResponse> businessUnits = new ArrayList<>();

        for ( BusinessUnit businessUnit : retrievedBusinessUnits ){
            businessUnits.add(businessUnitMapper.mapBusinessUnitResponseFromBusinessUnit(businessUnit));
        }

        return businessUnits;
    }
}
