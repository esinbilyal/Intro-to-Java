package com.adastragrp;

import java.sql.*;
import java.util.List;

public class SQLiteSaver implements ISave{
    @Override
    public void save(String saveLocation, List<PhoneBookEntry> phoneBookList) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:H:\\Intro to Java\\PhoneBook\\databases\\" + saveLocation);
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS phone_book_entry (person_name TEXT, phone_number TEXT)");
            for (PhoneBookEntry person : phoneBookList) {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO phone_book_entry (person_name, phone_number) VALUES(?,?)");
                ps.setString(1, person.getPersonsName());
                ps.setString(2, person.getPhoneNumber());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(String saveLocation) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:H:\\Intro to Java\\PhoneBook\\databases\\" + saveLocation)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from phone_book_entry");

            while (resultSet.next()) {
                System.out.printf("Person Name: %s → Phone Number: %s\n", resultSet.getString("person_name"), resultSet.getString("phone_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
