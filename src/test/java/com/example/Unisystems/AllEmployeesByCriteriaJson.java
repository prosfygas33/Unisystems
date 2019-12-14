package com.example.Unisystems;

public class AllEmployeesByCriteriaJson {

    public static String json = "{\n" +
            "    \"employees\": [\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "            \"fullName\": \"Panagiotis Milios\",\n" +
            "            \"telephone\": \"2108817081\",\n" +
            "            \"workingPeriod\": \"2010-01-14 00:10:00.0 - 2019-12-14 17:19:21.275\",\n" +
            "            \"status\": \"ACTIVE\",\n" +
            "            \"contactType\": \"ACTIVE\",\n" +
            "            \"position\": \"Junior Developer\",\n" +
            "            \"tasks\": [\n" +
            "                {\n" +
            "                    \"id\": 1,\n" +
            "                    \"title\": \"Java app\",\n" +
            "                    \"description\": \"Tournament\",\n" +
            "                    \"estimationA\": 5,\n" +
            "                    \"estimationB\": 4,\n" +
            "                    \"estimationC\": 3,\n" +
            "                    \"status\": \"DONE\",\n" +
            "                    \"updateList\": [],\n" +
            "                    \"difficultyFromEstimation\": \"Hard\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unit\": \"Debugging Squad\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 5,\n" +
            "            \"fullName\": \"George Dom\",\n" +
            "            \"telephone\": \"2105520081\",\n" +
            "            \"workingPeriod\": \"1998-01-31 00:12:00.0 - 2010-01-31 00:11:00.0\",\n" +
            "            \"status\": \"INACTIVE\",\n" +
            "            \"contactType\": \"ACTIVE\",\n" +
            "            \"position\": \" Mid-Senior Developer\",\n" +
            "            \"tasks\": [],\n" +
            "            \"unit\": \"Debugging Squad\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public static String jsonWrongInput = "{\n" +
            "    \"code\": 0,\n" +
            "    \"title\": \"Wrong Input\",\n" +
            "    \"desc\": \"This uni do not exist\"\n" +
            "}";

    public static String jsonNotFound = "{\n" +
            "    \"code\": 0,\n" +
            "    \"title\": \"Not Found\",\n" +
            "    \"desc\": \"No employee record exist for given id 1\"\n" +
            "}";
}
