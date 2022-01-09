package com.company;

public class Negative_balance_exception extends Throwable {
    private double sum;
    public Negative_balance_exception(double sum){
        this.sum = sum;
    }
    public double get_sum() { return sum; }
}
