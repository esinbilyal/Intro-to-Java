package com.adastragrp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Transaction {
    enum transactionType {
        Deposit, Withdrawal, Transfer
    }
    
    Account account;
    protected double amount;
    protected double balance;
    protected Date date;
    protected static transactionType transactionType;

    public Transaction(Account account, String dateS) {
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Transaction: \n" +
                "Transaction Date: " + date +
                ", Transaction Type: " + transactionType +
                ", Transaction Amount: " + amount + "\n";
    }
    
    static class Deposit extends Transaction {
        public Deposit(Account account, double depositAmount, String date) {
            super(account, date);
            this.balance = account.getAccountBalance();
            if (depositAmount >= 0) {
                this.balance += depositAmount;
                System.out.printf("Deposit of %.2f made. New balance is %.2f%n", depositAmount, this.balance);
                account.setAccountBalance(this.balance);
            } else {
                System.out.print("Invalid deposit amount!");
            }
            this.amount = depositAmount;
            this.transactionType = transactionType.Deposit;
        }
    }

    static class Withdrawal extends Transaction {
        public Withdrawal(Account account, double withdrawalAmount, String date) {
            super(account, date);
            this.balance = account.getAccountBalance();
            if (withdrawalAmount >= 0) {
                if (this.balance - withdrawalAmount < 0) {
                    System.out.printf("Only %.2f available. Withdrawal not processed!%n", this.balance);
                } else {
                    this.balance -= withdrawalAmount;
                    System.out.printf("Withdrawal of %.2f processed. Remaining balance %.2f%n", withdrawalAmount, this.balance);
                    account.setAccountBalance(balance);
                }
            } else {
                System.out.print("Invalid withdrawal amount!\n");
            }
            this.amount = withdrawalAmount;
            this.transactionType = transactionType.Withdrawal;
        }
    }

    static class Transfer extends Transaction {
        public Transfer(Account account, Account bankAccount, double transferAmount, String date) {
            super(account, date);
            this.balance = account.getAccountBalance();
            if (this.balance <= 0 || transferAmount < 0) {
                System.out.print("Invalid transfer\n");
            } else {
                bankAccount.setAccountBalance(bankAccount.getAccountBalance() + transferAmount);
                this.balance -= transferAmount;
                account.setAccountBalance(balance);
                System.out.printf("You transferred %.2f! Remaining balance: %.2f\n", transferAmount, this.balance);
                System.out.printf("Account with number %d received %.2f! New balance is %.2f\n", bankAccount.getAccountNumber(), transferAmount, bankAccount.getAccountBalance());
            }
            this.amount = transferAmount;
            this.transactionType = transactionType.Transfer;
        }
    }
}
