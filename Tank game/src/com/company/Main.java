package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tank tank = new Tank();
        menu(tank);
        tank.info();
        System.out.println("_-----------------------_");
    }
    public static void menu(Tank tank) {
        Scanner sc = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("x")) {
            System.out.println("[N] Move towards north");
            System.out.println("[E] Move towards east");
            System.out.println("[S] Move towards south");
            System.out.println("[W] Move towards west");
            System.out.println("[*] Fire!");
            System.out.println("[i] Info");
            System.out.println("[x] EXIT");
            choice = sc.next();
            switch (choice.toUpperCase()) {
                case "N":
                    tank.north();
                    break;
                case "E":
                    tank.east();
                    break;
                case "S":
                    tank.south();
                    break;
                case "W":
                    tank.west();
                    break;
                case "*":
                    tank.fire();
                    break;
                case "I":
                    tank.info();
                    break;
                case "X":
                    break;
                default:
                    System.out.println("------ Input not recognised! ------");
                    break;
            }
            System.out.println("-----------------------------------------------");
        }
    }
}
