package com.adastragrp;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook implements ISave{

    private final String phoneBookName;
    private PhoneBookEntry phoneBookEntry;

    public PhoneBook(String phoneBookName, PhoneBookEntry phoneBookEntry) {
        this.phoneBookName = phoneBookName;
        this.phoneBookEntry = phoneBookEntry;
    }

    public String getPhoneBookName() {
        return phoneBookName;
    }

    @Override
    public List<PhoneBookEntry> save() {
        List<PhoneBookEntry> phoneBookEntryList = new ArrayList<>();
        phoneBookEntryList.add(0, this.phoneBookEntry);
        return phoneBookEntryList;
    }

    @Override
    public void load(List<PhoneBookEntry> savedPhoneBookEntries) {
        if(savedPhoneBookEntries != null && savedPhoneBookEntries.size() > 0) {
            this.phoneBookEntry = savedPhoneBookEntries.get(0);
        }
    }
}
