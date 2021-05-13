package com.adastragrp;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class JsonSaver implements ISave {
    @Override
    public void save(String saveLocation, List<PhoneBookEntry> phoneBookList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(phoneBookList);
        try (FileWriter file = new FileWriter(saveLocation)) {
            file.write(jsonString);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(String saveLocation) {
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(saveLocation));
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(reader).getAsJsonArray();
            for(JsonElement element : jsonArray) {
                JsonObject phoneBookObj = element.getAsJsonObject();
                System.out.print("Person Name: " + phoneBookObj.get("personsName").getAsString() + ", Phone Number: " + phoneBookObj.get("phoneNumber").getAsString() + "\n");
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
