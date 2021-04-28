package com.adastragrp;

import java.util.List;

public interface ISave {
    List<PhoneBookEntry> save();
    void load(List<PhoneBookEntry> savedPhoneBookEntries);
}
