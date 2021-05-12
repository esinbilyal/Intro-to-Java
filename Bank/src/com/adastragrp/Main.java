package com.adastragrp;

public class Main {

    public static void main(String[] args) {
        Account accountOne = new Account(1, "10/05/2021", 0.15, 5000, accountType.current);
        Account accountTwo = new Account(2,"09/05/2021",0.15,2500,accountType.deposit);
        accountOne.newTransaction(Transaction.transactionType.Deposit, 200, "15/05/2021");
        accountTwo.newTransaction(Transaction.transactionType.Withdrawal, 500, "20/05/2021");
        accountOne.newTransfer(500, accountTwo, "30/05/2021");
        //System.out.printf(accountOne.getTransactionHistory());

        SaveFactory saveFactory = new SaveFactory();
        ISave myJSONSaver = saveFactory.init("json");
        String saveLocationJSON = "H:\\Intro to Java\\Bank\\bankAccounts.json";
        String saveLocationSQLite = "bankAccount.db";

        myJSONSaver.save(saveLocationJSON, accountOne);
        myJSONSaver.load("bankAccounts.json");

        ISave mySQLiteSaver = saveFactory.init("sqlite");
        mySQLiteSaver.save(saveLocationSQLite, accountOne);
        mySQLiteSaver.load(saveLocationSQLite);
    }
}
