package com.adastragrp;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.LinkedTransferQueue;

public class JsonSaver implements ISave{

    @Override
    public void save(String saveLocation, Account account) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(account);
        try (FileWriter file = new FileWriter(saveLocation)) {
            file.write(jsonString);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(String saveLocation) {
        try {
            JsonReader reader = new JsonReader(new FileReader(saveLocation));
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(reader).getAsJsonObject();
            System.out.println("Account Number: " + jsonObject.get("accountNumber"));
            System.out.println("Date Of Opening: " + jsonObject.get("dateOfOpening"));
            System.out.println("Interest Rate: " + jsonObject.get("interestRate"));
            System.out.println("Account Balance: " + jsonObject.get("accountBalance"));
            System.out.println("Account Type: " + jsonObject.get("accountType"));
            JsonArray transactionsList = (JsonArray) jsonObject.get("transactionHistory");
            Iterator<JsonElement> iterator = transactionsList.iterator();
            while (iterator.hasNext()) {
                System.out.println("Transactions: ");
                System.out.println(iterator.next());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
