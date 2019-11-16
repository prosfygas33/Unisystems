package com.example.Unisystems.BusinessUnit;

import org.springframework.stereotype.Component;

@Component
public class BusinessUnitMapper {

    public BusinessUnitResponse mapBusinessUnitResponseFromBusinessUnit(BusinessUnit businessUnit){
        return new BusinessUnitResponse(
                businessUnit.getId(),
                businessUnit.getName(),
                businessUnit.getCompany()
        );
    }

}
