package com.company;

public class User extends Warehouse {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String role;
    private float balance;

    public User(String username, String password, String name, String surname, String role, float balance) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.balance = balance;
    }

    public User() {

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setBalance(float balance) { this.balance = balance; }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getRole() {
        return role;
    }

    public float getBalance() { return balance; }

    //--------------------------------------------------------------------------------------------

    public String getCustomerInfo() {
        return "Username: " + username + '\n' +
                "Name: " + name + '\n' +
                "Surname: " + surname + '\n';

    }

    //--------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role='" + role + '\'' +
                ", balance=" + balance +
                '}';
    }
}

