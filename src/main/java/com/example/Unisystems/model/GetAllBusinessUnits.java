package com.example.Unisystems.model;

import java.util.List;

public class GetAllBusinessUnits {

    private List<BusinessUnitResponse> businessUnits;

    public GetAllBusinessUnits(List<BusinessUnitResponse> businessUnits) {
        this.businessUnits = businessUnits;
    }

    public List<BusinessUnitResponse> getBusinessUnits() {
        return businessUnits;
    }

    public void setBusinessUnits(List<BusinessUnitResponse> businessUnits) {
        this.businessUnits = businessUnits;
    }
}
