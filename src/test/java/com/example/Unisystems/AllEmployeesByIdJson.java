package com.example.Unisystems;

public class AllEmployeesByIdJson {

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
            "        }\n" +
            "    ]\n" +
            "}";

    public static String jsonNotFound = "{\n" +
            "    \"code\": 0,\n" +
            "    \"title\": \"Not Found\",\n" +
            "    \"desc\": \"No employee record exist for given id 1000\"\n" +
            "}";
}
