package com.adastragrp;

import org.json.simple.JSONObject;

import java.util.List;

public interface ISave {
    void save(String saveLocation, List<PhoneBookEntry> phoneBookList);
    void load(String saveLocation);
}
