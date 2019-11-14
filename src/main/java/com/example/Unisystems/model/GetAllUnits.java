package com.example.Unisystems.model;

import java.util.List;

public class GetAllUnits {

    private List<UnitResponse> unitResponses;

    public GetAllUnits(List<UnitResponse> unitResponses) {
        this.unitResponses = unitResponses;
    }

    public List<UnitResponse> getUnitResponses() {
        return unitResponses;
    }

    public void setUnitResponses(List<UnitResponse> unitResponses) {
        this.unitResponses = unitResponses;
    }
}
