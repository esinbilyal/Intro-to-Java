package com.adastragrp;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SlotMachine slotMachine = new SlotMachine();
        boolean flag = false;
        slotMachine.startGame();
        play(slotMachine);
        do {
            System.out.printf("Do you want to play again? /Enter \"yes\" or \"no\"/  ");
            String userAnswer = scanner.next();
            userAnswer.toLowerCase();
            if (userAnswer.equals("yes") || userAnswer.equals("no")) {
                if (userAnswer.equals("yes")) {
                    play(slotMachine);
                } else if (userAnswer.equals("no")) {
                    System.out.printf("Total amount of money you entered into the slot machine: %d\n", slotMachine.getEnteredMoney());
                    System.out.printf("Total budget: %d\n", slotMachine.getBudget());
                    flag = true;
                    break;
                }
            } else {
                System.out.print("Please enter \"yes\" or \"no\"\n");
            }
            if (flag) {
                break;
            }
        } while (slotMachine.getBudget() > 0);

        if (slotMachine.getBudget() <= 0) {
            System.out.printf("You do not have enough money to play more!");
        }
    }

    public static void play(SlotMachine slotMachine) {
        int bet;
        System.out.printf("Enter the amount of money you want to bid: ");
        do {
            int inputBet = scanner.nextInt();
            bet = slotMachine.makeBet(inputBet);
        } while (bet < 0);

        List<String> earningCombination = slotMachine.spin();
        System.out.printf("Result of spin: ");
        slotMachine.printList(earningCombination);

        int earnedPrize = slotMachine.getEarnedPrize(earningCombination, bet);
        slotMachine.addEarnedPrizeToBudget(earnedPrize);
        System.out.printf("Your total money: $%d\n", slotMachine.getBudget());
    }
}
