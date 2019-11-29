package com.example.Unisystems.TaskStrategy;


import org.springframework.stereotype.Component;

@Component
public class SearchTaskStrategyFactory {

    public SearchTaskStrategy makeStrategyForCriteria(String difficulty, Long numberOfEmployees){
        if ( numberOfEmployees == null && difficulty != null ) {
            System.out.println("EDW");
            if (difficulty.equalsIgnoreCase("Easy")) {
                return new SearchTaskByEasyDifficultyStrategy();
            } else if (difficulty.equalsIgnoreCase("Medium")) {
                return new SearchTaskByMediumDifficultyStrategy();
            } else if (difficulty.equalsIgnoreCase("Hard")) {
                System.out.println("EDW1");
                return new SearchTaskByHardDifficultyStrategy();
            }else{
                return null;
            }
        }else if ( difficulty == null && numberOfEmployees != null){
            return new SearchTaskByNumberOfEmployees();
        }
        else if ( difficulty != null && numberOfEmployees != null){
            return new SearchTaskByDifficultyAndNumberOfEmployeesStrategy();
        }else{
            return null;
        }
    }
}
