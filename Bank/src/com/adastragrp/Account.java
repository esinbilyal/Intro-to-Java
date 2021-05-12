package com.adastragrp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private int accountNumber;
    private String dateOfOpeningS;
    private Date dateOfOpening;
    private double interestRate, accountBalance;
    private accountType accountType;
    private List<Transaction> transactionHistory = new ArrayList<>();

    public Account(int accountNumber, String dateOfOpeningS, double interestRate, double accountBalance, accountType accountType) {
        this.accountNumber = accountNumber;
        try {
            dateOfOpening = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfOpeningS);
            this.dateOfOpening = dateOfOpening;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.interestRate = interestRate;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
    }


    public void newTransaction(Transaction.transactionType transactionType, double amount, String date) {
        Transaction newTransaction;
        switch (transactionType) {
            case Withdrawal -> newTransaction = new Transaction.Withdrawal(this, amount, date);
            case Deposit -> newTransaction = new Transaction.Deposit(this, amount, date);
            default -> throw new UnsupportedOperationException("Unsupported operation");
        }
        if(this.accountType.equals(com.adastragrp.accountType.current)) {
            this.accountBalance -= (accountBalance / interestRate) / 100;
            System.out.print("Interest calculated\n");
        }
        accrueInterest(this, newTransaction.date);
        transactionHistory.add(newTransaction);
    }

    public void newTransfer(double amount, Account bankAccount, String date) {
        Transaction newTransaction;
        newTransaction = new Transaction.Transfer(this, bankAccount, amount, date);
        accrueInterest(this ,newTransaction.date);

        if(this.accountType.equals(com.adastragrp.accountType.current)) {
            this.accountBalance -= (accountBalance / interestRate) / 100;
            System.out.print("Interest calculated\n");
        }

        transactionHistory.add(newTransaction);
    }

    public void accrueInterest(Account account, Date transactionDate) {
        Date date = new Date();
        switch (account.accountType) {
            case deposit: {
                if(transactionDate.after(DateAddAndSubtract.addDays(date, 5))) {
                    account.accountBalance -= (account.accountBalance / account.interestRate) / 100;
                    System.out.print("Interest calculated\n");
                }
            } break;
            case current: {
                if(transactionDate.after(DateAddAndSubtract.addDays(date, 1))) {
                    account.accountBalance -= (account.accountBalance / account.interestRate) / 100;
                    System.out.print("Interest calculated\n");
                }
            } break;
            default: {
                System.out.print("The account is undefined\n");
            }
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getDateOfOpening() {
        return dateOfOpening;
    }

    public void setDateOfOpening(String dateOfOpeningS) {
        try {
            dateOfOpening = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfOpeningS);
            this.dateOfOpening = dateOfOpening;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public com.adastragrp.accountType getAccountType() {
        return accountType;
    }

    public void setAccountType(com.adastragrp.accountType accountType) {
        this.accountType = accountType;
    }

    public String getTransactionHistory() {
        return "Account with account number " + accountNumber +
                " has a transaction history: \n" + transactionHistory.toString();
    }
}
