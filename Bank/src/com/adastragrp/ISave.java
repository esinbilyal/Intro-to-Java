package com.adastragrp;

import com.adastragrp.Account;

public interface ISave {
    void save(String saveLocation, Account account);
    void load(String saveLocation);
}
