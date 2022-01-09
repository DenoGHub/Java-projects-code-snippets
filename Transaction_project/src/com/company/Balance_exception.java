package com.company;

public class Balance_exception extends Throwable {
    private double balance;
    public Balance_exception(String message, double balance) {
        super(message);
        this.balance = balance;
    }
    public double get_balance() {
        return balance;
    }
}
