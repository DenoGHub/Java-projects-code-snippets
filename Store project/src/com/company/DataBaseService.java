package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBaseService extends User {
    private String path;

    public DataBaseService(String path) {
        super();
        this.path = path;
    }

    //--------------------------------------------------------------------------------------------

    public void buyItems() {

        float sum = getBalance() - getPrice();
    }

    //--------------------------------------------------------------------------------------------

//    public void overWriteBalance(User user, Warehouse warehouse) {
//        FileWriter fw = null;
//        try {
//            fw = new FileWriter(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (warehouse.getQuantity() >= 0) {
//            System.out.println(user.getBalance() - warehouse.getPrice());
//        }
//        PrintWriter writer = new PrintWriter(fw);
//        writer.println(user.getBalance());
//        writer.close();
//    }

    //--------------------------------------------------------------------------------------------

    public ArrayList<Warehouse> getWarehouseItems() {
        File file = new File(path);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Warehouse> warehouseElements = new ArrayList<>();
        while (scan.hasNextLine()) {
            String product = scan.nextLine();
            int price = Integer.valueOf(scan.nextLine());
            int quantity = Integer.valueOf(scan.nextLine());
            scan.nextLine();
            warehouseElements.add(new Warehouse(product, price, quantity));
        }
        return warehouseElements;
    }

    //--------------------------------------------------------------------------------------------

    public ArrayList<User> getAllUsers() {
        File file = new File(path);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<User> users = new ArrayList<>();
        while (scan.hasNextLine()) {
            String username = scan.nextLine();
            String password = scan.nextLine();
            String name = scan.nextLine();
            String surname = scan.nextLine();
            String role = scan.nextLine();
            float balance = Float.parseFloat(scan.nextLine());
            scan.nextLine();
            users.add(new User(username, password, name, surname, role, balance));
        }
        return users;
    }

    //--------------------------------------------------------------------------------------------

    public User login (String username, String password) throws DataBaseServiceException {
        ArrayList<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new DataBaseServiceException("*** Incorrect username or password ***");
    }

    //--------------------------------------------------------------------------------------------

    public void addUser(User user) throws DataBaseServiceException {
        for (User userFromDb : getAllUsers()) {
            if(userFromDb.getUsername().equals(user.getUsername())) {
                throw new DataBaseServiceException("Such username already exist");

            }
        }
        writeUser(user);
    }

    //--------------------------------------------------------------------------------------------

    public void deleteUser(String username) throws DataBaseServiceException {
        ArrayList<User> users = getAllUsers();
        boolean exist = false;
        for(User user : users) {
            if(user.getUsername().equals(username)) {
                exist = true;
                users.remove(user);
                break;
            }
        }
        if(!exist){
            throw new DataBaseServiceException("Such user does not exist");
        }
        rewriteFile(users);
    }

    //--------------------------------------------------------------------------------------------

    public void addItem(Warehouse warehouse) throws DataBaseServiceException {
        for (Warehouse warehouseFromDb : getWarehouseItems()) {
            if(warehouseFromDb.getProduct().equals(warehouse.getProduct())) {
                throw new DataBaseServiceException("*** Such product already exist ***");
            }
        }
        addItems(warehouse);
    }

    //--------------------------------------------------------------------------------------------

    public void overWriteBalance () {
        ArrayList<User> user = getAllUsers();
        Scanner sc = new Scanner (path);
        float deposit = Float.parseFloat(sc.nextLine());
        float balance = Float.parseFloat(sc.nextLine());
        if (deposit > 0) {
                deposit += balance;
            } else {
                System.out.println("*** Deposit value cannot 0 or less than 0! ***");
            }
        rewriteFile(user);
        System.out.println("*** You deposited '" + deposit +"€' ***");
        System.out.println("--------------------------------");
        System.out.println("*** Your total balance is: '"+ balance +"€' ***");

    }

    public void deleteItems(String product) throws DataBaseServiceException {
        ArrayList<Warehouse> warehouses = getWarehouseItems();
        boolean exist = false;
        for (Warehouse warehouse: warehouses) {
            if(warehouse.getProduct().equals(product)) {
                exist = true;
                warehouses.remove(warehouse);
                break;
            }
        }
        if(!exist) {
            throw new DataBaseServiceException("*** Such items already exists in store ***");
        }
        rewriteWarehouseFile(warehouses);

    }

    //--------------------------------------------------------------------------------------------

    private void rewriteFile(ArrayList<User> users) {
        PrintWriter writer = getPrintWriter(false);
        for (User user: users) {
            writeSingleUserToDb(user, writer);
        }
        writer.close();

    }

    //--------------------------------------------------------------------------------------------

    private void writeUser(User user) {
        PrintWriter writer = getPrintWriter(true);

        writeSingleUserToDb(user, writer);

        writer.close();
    }

    //--------------------------------------------------------------------------------------------

    private void writeSingleUserToDb(User user, PrintWriter writer) {
        writer.println(user.getUsername());
        writer.println(user.getPassword());
        writer.println(user.getName());
        writer.println(user.getSurname());
        writer.println(user.getRole());
        writer.println(user.getBalance());
        writer.println();
    }

    //--------------------------------------------------------------------------------------------

    private PrintWriter getPrintWriter(boolean append) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path, append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new PrintWriter(fw);
    }

    //--------------------------------------------------------------------------------------------

    private void addItems (Warehouse warehouse) {
       PrintWriter writer = getWarehousePrintWriter(true);

       writeSingleProductToDb(warehouse, writer);

       writer.close();
   }

    //--------------------------------------------------------------------------------------------

    private void writeSingleProductToDb(Warehouse warehouse, PrintWriter writer) {
        writer.println(warehouse.getProduct());
        writer.println(warehouse.getPrice());
        writer.println(warehouse.getQuantity());
        writer.println();
    }

    //--------------------------------------------------------------------------------------------

    private PrintWriter getWarehousePrintWriter(boolean append) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path, append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new PrintWriter(fw);
    }

    //--------------------------------------------------------------------------------------------

    private void rewriteWarehouseFile (ArrayList<Warehouse> warehouses) {
        PrintWriter writer = getPrintWriter(false);

        for (Warehouse warehouse: warehouses) {
            writeSingleProductToDb(warehouse, writer);
        }
        writer.close();

    }

    //--------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "balance:" + getBalance() + '\n'
                + "price: " + getPrice();
    }
}
