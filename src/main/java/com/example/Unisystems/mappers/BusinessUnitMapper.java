package com.example.Unisystems.mappers;

import com.example.Unisystems.model.BusinessUnit;
import com.example.Unisystems.model.BusinessUnitResponse;
import com.example.Unisystems.repositories.BusinessUnitRepository;
import org.springframework.stereotype.Component;

@Component
public class BusinessUnitMapper {

    public BusinessUnitResponse mapBusinessUnitResponseFromBusinessUnit(BusinessUnit businessUnit){
        return new BusinessUnitResponse(
                businessUnit.getId(),
                businessUnit.getName(),
                businessUnit.getType(),
                businessUnit.getCompany()
        );
    }

}
