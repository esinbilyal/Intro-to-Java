package com.adastragrp;

public class SaveFactory {
    public ISave init(String fileType) {
        if(fileType.equalsIgnoreCase("json")) {
            return new JsonSaver();
        } else if(fileType.equalsIgnoreCase("sqlite")) {
            return new SQLiteSaver();
        }
        return null;
    }
}
