package com.example.Unisystems.BusinessUnit;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessUnitService {

    BusinessUnitMapper businessUnitMapper;
    BusinessUnitRepository businessUnitRepository;

    public BusinessUnitService(BusinessUnitMapper businessUnitMapper, BusinessUnitRepository businessUnitRepository) {
        this.businessUnitMapper = businessUnitMapper;
        this.businessUnitRepository = businessUnitRepository;
    }

    public List<BusinessUnitResponse> getBusinessUnits(){
        Iterable<BusinessUnit> retrievedBusinessUnits = businessUnitRepository.findAll();
        List<BusinessUnitResponse> businessUnits = new ArrayList<>();

        for ( BusinessUnit businessUnit : retrievedBusinessUnits ){
            businessUnits.add(businessUnitMapper.mapBusinessUnitResponseFromBusinessUnit(businessUnit));
        }
        return businessUnits;
    }
}
