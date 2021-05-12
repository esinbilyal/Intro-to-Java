package com.adastragrp;

import java.sql.*;

public class SQLiteSaver implements ISave {
    @Override
    public void save(String saveLocation, Account account) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:H:\\Intro to Java\\Bank\\databases\\" + saveLocation);
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS bank_account " +
                    "(account_number INTEGER, dateOfOpening DATE, interestRate DOUBLE, accountBalance DOUBLE, accountType TEXT, " +
                    "transactions TEXT)");
//            statement.execute("CREATE TABLE IF NOT EXISTS transactions" +
//                    "(transactionID INTEGER PRIMARY KEY AUTOINCREMENT, amount DOUBLE, balance DOUBLE, dateOfTransaction DATE )");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO bank_account (account_number, dateOfOpening," +
                    ", interestRate, accountBalance, accountType, transactions) VALUES(?,?,?,?,?,?)");
            ps.setInt(1, account.getAccountNumber());
            ps.setDate(2, (Date) account.getDateOfOpening());
            ps.setDouble(3, account.getInterestRate());
            ps.setDouble(4, account.getAccountBalance());
            ps.setString(5, String.valueOf(account.getAccountType()));
            ps.setString(6, account.getTransactionHistory());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(String saveLocation) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:H:\\Intro to Java\\Bank\\databases\\" + saveLocation)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from bank_account");

            while (resultSet.next()) {
                System.out.printf("Account Number: %d,\nDate Of Opening: %s\nInterest Rate: %f\nAccount balance: %f\n Account type: %s\nTransactions: %s\n", resultSet.getInt("account_number"), resultSet.getString("dateOfOpening"), resultSet.getDouble("interestRate"), resultSet.getDouble("accountBalance"), resultSet.getString("accountType"), resultSet.getString("transactions"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
