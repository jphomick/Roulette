package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Welcome to Roulette!\n");
        String bet = "";
        int won = 0;
        int lost = 0;
        double moneyEarned = 0;
        while (!bet.equals("false")) {
            Bet roulette = new Bet();
            while (roulette.getBetType() == -1) {
                System.out.println("Enter your bet type: (red|black|even|odd|high|low)");
                roulette.setType(read.nextLine());
            }
            System.out.println("Enter the money to bet:");
            double amount = 0;
            while (amount <= 0) {
                amount = read.nextDouble();
            }
            read.nextLine();
            double result = roulette.gamble(amount) - amount;
            if (result > 0) {
                System.out.println("You won the bet!\n");
                won++;
            } else {
                System.out.println("Sorry, you lost the bet.\n");
                lost++;
            }
            moneyEarned += result;
            System.out.println("Current money earned: $" + String.format("%.2f", moneyEarned) +
                    "\n\nWould you like to play again? (true|false)");
            bet = read.nextLine();
        }
        System.out.println("Thank you for playing!\nYou earned: $" + String.format("%.2f", moneyEarned)
                + "\nYou won " + won + " and lost " + lost + "!");
    }
}
