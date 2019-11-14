package com.example.Unisystems.services;

import com.example.Unisystems.mappers.BusinessUnitMapper;
import com.example.Unisystems.model.BusinessUnit;
import com.example.Unisystems.model.BusinessUnitResponse;
import com.example.Unisystems.repositories.BusinessUnitRepository;
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
