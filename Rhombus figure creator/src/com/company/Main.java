package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the size of rhombus:");
        int size = sc.nextInt();
        int center = (size / 2) + 1;

        if(size % 2 != 0) {
            StringBuilder spaces = new StringBuilder(" ");
            StringBuilder symbol = new StringBuilder("*");

            for(int i = 0; i < center; i++) {
                spaces.append(" ");
            }

            for(int i = 0; i < center - 1; i++) {
                System.out.println(spaces.toString() + symbol);
                spaces = new StringBuilder(spaces.substring(0, spaces.length() - 1));
                symbol.append("**");
            }
            for (int i = 0; i < center - 1; i++) {
                spaces.append(" ");
                symbol = new StringBuilder(symbol.substring(0, symbol.length() - 2));
                System.out.println(spaces.toString() + symbol);
            }

        } else {
            System.out.println("Rhombus cannot be formed from even number!");
        }

    }
}
