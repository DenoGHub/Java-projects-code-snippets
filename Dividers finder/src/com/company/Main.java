package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the number you want to check:");
        int number = sc.nextInt();

        int numberOfDividers = 0;
        int sum = 0;
        int multiplication = 1;
        StringBuilder dividers = new StringBuilder();

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                numberOfDividers++;
                sum += i;
                multiplication *= i;
                dividers.append(i).append(" ");
            }
        }

        String choice = "";
        while (!choice.equals("5")) {
            System.out.println("---------------------------------------------");
            System.out.println("[1] find all number dividers");
            System.out.println("[2] find how much dividers the number has");
            System.out.println("[3] find dividers total");
            System.out.println("[4] find dividers multiplication");
            System.out.println("[5] EXIT");
            System.out.println("---------------------------------------------");
            choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("Dividers: " + dividers);
                    break;
                case "2":
                    System.out.println("Number " + number + " has " + numberOfDividers + " dividers");
                    break;
                case "3":
                    System.out.println("Dividers total: " + sum);
                    break;
                case "4":
                    System.out.println("Dividers multiplied: " + multiplication);
                    break;
                case "5":
                    break;
                default:
                    System.out.println("-------- Input not recognised! --------");
                    break;
            }
        }
    }
}
