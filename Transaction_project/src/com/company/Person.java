package com.company;

public class Person {
    private String name;
    private String surname;
    private double balance;
    public Person(String name, String surname, double balance) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }
    public void withdraw(double sum) throws Balance_exception, Negative_balance_exception {
        if(sum < 0) {
            throw new Negative_balance_exception(sum);
        }
        if (balance - sum >= 0) {
            balance -= sum;
        } else {
            throw new Balance_exception("Balance too low!", balance - sum);
        }
    }
    @Override
    public String toString() {
        return "name: " + name + "\n" +
                "surname :" + surname + "\n" +
                "balance :" + balance;
    }
}
