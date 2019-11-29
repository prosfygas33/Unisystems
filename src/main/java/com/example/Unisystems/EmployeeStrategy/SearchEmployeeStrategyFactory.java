package com.example.Unisystems.EmployeeStrategy;

import org.springframework.stereotype.Component;

@Component
public class SearchEmployeeStrategyFactory {

    public SearchEmployeeStrategy makeStrategyForCriteria(String criteria){
        if ( criteria.equalsIgnoreCase("Company")){
            return new SearchEmployeeByUnitStrategy();
        }else if ( criteria.equalsIgnoreCase("BusinessUnit")){
            return new SearchEmployeeByBusinessUnitStrategy();
        }else if ( criteria.equalsIgnoreCase("Department")){
            return new SearchEmployeeByDepartmentStrategy();
        }else if ( criteria.equalsIgnoreCase("Unit")){
            return new SearchEmployeeByUnitStrategy();
        }else{
            //Mporoume na kanoume return to UnitStrategy() pou einai amesa sundedemeno me ton EMployee
            return null;
        }
    }
}
