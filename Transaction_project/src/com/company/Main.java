package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Tom", "Tomcat", 500);
        Scanner sc = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("3")) {
            System.out.println("[1] Send money");
            System.out.println("[2] Show persons information");
            System.out.println("[3] EXIT");
            choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("Enter the amount");
                    double sum = sc.nextDouble();
                    try {
                        withdraw(person, sum);
                    } catch (Balance_exception e) {
                        System.out.println("Transaction failed! If you transfer that much the balance of the account would be: " + e.get_balance());
                    } catch (Negative_balance_exception | IllegalArgumentException | InputMismatchException e) {
                        System.out.println("Invalid input!");
                    }
            break;
                case "2":
                    System.out.println("\n" + person + "\n");
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Input not recognized!");
                    break;
            }
        }
    }
    public static void withdraw(Person person, double sum) throws Balance_exception, Negative_balance_exception {
        person.withdraw(sum);
    }
}
