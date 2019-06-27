package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Bet {
    private int betType;
    private ArrayList<String> types;

    public Bet() {
        types = new ArrayList<>();
        types.add("red");
        types.add("black");
        types.add("even");
        types.add("odd");
        types.add("low");
        types.add("high");
        betType = -1;
    }

    public double gamble(double money) {
        Random r = new Random();
        int number = r.nextInt(36) + 1;
        boolean red = r.nextBoolean();
        String color = "red";
        if (!red) {
            color = "black";
        }
        boolean win = false;
        System.out.println("The ball landed on " + number + " " + color + ".");
        if (betType == 0 && red) {
            win = true;
        } else if (betType == 1 && !red) {
            win = true;
        } else if (betType == 2 && number % 2 == 0) {
            win = true;
        } else if (betType == 3 && number % 2 == 1) {
            win = true;
        } else if (betType == 4 && number <= 18) {
            win = true;
        } else if (betType == 5 && number > 18) {
            win = true;
        }
        if (win) {
            return money * 2;
        } else {
            return 0;
        }
    }

    public boolean setType(String type) {
        if (types.contains(type)) {
            betType = types.indexOf(type);
            return true;
        } else {
            return false;
        }
    }

    public int getBetType() {
        return betType;
    }
}
