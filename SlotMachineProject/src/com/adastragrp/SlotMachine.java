package com.adastragrp;

import java.util.*;

public class SlotMachine {
    private int budget = 100;
    private int enteredMoney = 0;
    private List<String> fruitsList = new ArrayList<>(Arrays.asList("Cherries", "Oranges", "Plums", "Bells", "Melons", "Bars"));

    public int getBudget() {
        return budget;
    }

    public int getEnteredMoney() {
        return enteredMoney;
    }

    public int addEarnedPrizeToBudget(int earnedAmount) {
        return budget += earnedAmount;
    }

    public void startGame() {
        int userBudget = getBudget();
        System.out.printf("Welcome! Your initial budget is $%d%n", userBudget);
    }

    public int validateBet(int bet) {
        if (budget - bet < 0) {
            System.out.printf("You do not have enough amount of money. Please enter new value: ");
            return -1;
        } else if (bet < 0) {
            System.out.printf("Negative amount of money. Please enter new value: ");
            return -1;
        } else {
            return 1;
        }
    }

    public int makeBet(int bet) {
        if (validateBet(bet) > 0 && budget > 0) {
            System.out.printf("Your bet is $%d\n", bet);
            budget -= bet;
            enteredMoney += bet;
            return bet;
        } else {
            return -1;
        }
    }

    public List<String> spin() {
        int numberOfElements = 3;
        Random random = new Random();
        List<String> newFruitsList = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = random.nextInt(fruitsList.size());
            newFruitsList.add(fruitsList.get(randomIndex));
        }
        return newFruitsList;
    }

    public void printList(List<String> list) {
        for (String element : list) {
            System.out.printf("%s | ", element);
        }
        System.out.printf("\n");
    }

    public int getEarnedPrize(List<String> list, int bet) {
        int countCherries = Collections.frequency(list, "Cherries");
        int countOranges = Collections.frequency(list, "Oranges");
        int countPlums = Collections.frequency(list, "Plums");
        int countBells = Collections.frequency(list, "Bells");
        int countMelons = Collections.frequency(list, "Melons");
        int countBars = Collections.frequency(list, "Bars");

//        for(String fruit : list) {
//            switch (fruit) {
//                case "Cherries": countCherries++; break;
//                case "Oranges": countOranges++; break;
//                case "Plums": countPlums++; break;
//                case "Bells": countBells++; break;
//                case "Bars": countBars++; break;
//                default: break;
//            }
//        }
        int prize = payout(bet, countCherries, countOranges, countPlums, countBells, countMelons, countBars);
        return prize;
    }

    public int payout(int bet, int countCherries, int countOranges, int countPlums, int countBells,
                      int countMelons, int countBars) {
        int prize = 0;
        if (countCherries == 3 || countOranges == 3 || countPlums == 3 || countBells == 3 || countMelons == 3 || countBars == 3) {
            prize += bet * 3;
            System.out.printf("You won three times the amount entered. The prize is: %d\n", prize);
            return prize;
        } else if (countCherries == 2 || countOranges == 2 || countPlums == 2 || countBells == 2 || countMelons == 2 || countBars == 2) {
            prize += bet * 2;
            System.out.printf("You won two times the amount entered. The prize is: %d\n", prize);
            return prize;
        } else {
            System.out.printf("You won $0\n");
            return prize;
        }
    }
}