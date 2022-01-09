package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Takes input from user, adds it to the list until maximum size of array elements is reached.
     */
    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Waiting for input -----");

        for (;;) {
            String word = sc.nextLine();
            if (words.contains(word)) {
                System.out.println("----- Such element already exist in the list -----");
                System.out.println(words);
            } else {
                words.add(word);
                System.out.println(words);
            }
            if (words.size() == 5) {
                System.out.println("----- Maximum elements in the list reached -----\n----- New list started -----");
                words.clear();
            }
        }

    }
}
