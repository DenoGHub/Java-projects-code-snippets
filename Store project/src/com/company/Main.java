package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends User {
    /**
     * From user menu "buy items" and "deposit funds" functionality are not implemented yet
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataBaseService service = new DataBaseService("src\\com\\company\\userData.txt");
//        DataBaseService warehouse = new DataBaseService("src\\com\\company\\warehouse.txt");
        String choice = "";

//--------------------------------------------------------------------------------------------

        while (!choice.equals("3")) {
            menu();
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Username:");
                    String username = sc.nextLine();
                    System.out.println("Password:");
                    String password = sc.nextLine();
                    try {
                        User loggedInUser = service.login(username, password);
                        if (loggedInUser.getRole().toLowerCase().equals("customer")) {
                            System.out.println('\n' +"*** Welcome " + username + " ***" + '\n');
                            customerOptions();
                        } else if (loggedInUser.getRole().toLowerCase().equals("admin")) {
                            System.out.println('\n' +"*** Welcome Admin ***" + '\n');
                            adminOptions();
                        }
                    } catch (DataBaseServiceException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                   User toBeRegistered = createUser();
                    try {
                        service.addUser(toBeRegistered);
                        System.out.println('\n' + "*** User registered! ***" + '\n');

                    } catch (DataBaseServiceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    //EXIT
                    break;
                default:
                    System.out.println("Input not recognised");
            }
        }

    }

    //--------------------------------------------------------------------------------------------

    public static void customerOptions() throws IOException {
        Scanner sc = new Scanner(System.in);
        DataBaseService warehouse = new DataBaseService("src\\com\\company\\warehouse.txt");
        DataBaseService service = new DataBaseService("src\\com\\company\\userData.txt");
        String choice = "";

        while (!choice.equals("4")) {
            customerMenu();
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                   ArrayList<Warehouse> warehouses = warehouse.getWarehouseItems();
                   for(Warehouse warehouse1: warehouses) {                              //Show items list
                       System.out.println(warehouse1.getAllWarehouseItems());
                       System.out.println("----------------------------");
                   }

                    break;
                case "2":
                    String buyItem;
                    buyItem = sc.nextLine();
                    ArrayList<Warehouse> warehousee = warehouse.getWarehouseItems();
                        if (warehousee.equals(buyItem)) {
                            int boughtItems = warehouse.getQuantity() - 1;
                            System.out.println(boughtItems);
                        } else {
                            System.out.println("We don't have '"+ buyItem +"' product");
                        }

                    break;
                case "3":
                    float balance = Float.parseFloat(sc.nextLine());      //Deposit money
                    service.overWriteBalance();

                    break;
                case "4":
                    //EXIT
                    break;
                default:
                    System.out.println("Input not recognized");
                    break;
            }
        }

    }

    //--------------------------------------------------------------------------------------------

    public static void adminOptions() {
        Scanner sc = new Scanner(System.in);
        DataBaseService warehouse = new DataBaseService("src\\com\\company\\warehouse.txt");
        DataBaseService service = new DataBaseService("src\\com\\company\\userData.txt");
        String choice = "";

        while(!choice.equals("7")) {
            adminMenu();
            choice = sc.nextLine();

            switch(choice) {
                case "1":
                    ArrayList<Warehouse> warehouses = warehouse.getWarehouseItems();
                    for(Warehouse warehouse1: warehouses) {
                        System.out.println(warehouse1.getAllWarehouseItems());
                        System.out.println("----------------------------");
                    }
                    break;
                case "2":
                    Warehouse toBeAdded = createItem();
                    try {
                        warehouse.addItem(toBeAdded);
                    } catch (DataBaseServiceException e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    System.out.println("Type in product name that you want to remove");
                    String product = sc.nextLine();
                    try {
                        warehouse.deleteItems(product);
                        System.out.println("\n*** Item" + " '" + product +"'" + " has been removed! ***\n");
                    } catch (DataBaseServiceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    ArrayList<User> users = service.getAllUsers();
                    for (User user: users) {
                        System.out.println(user.getCustomerInfo());
                        System.out.println("--------------------");
                        System.out.println();
                    }
                    break;
                case "5":
                    System.out.println("Type in customer username");
                    String username = sc.nextLine();
                    try {
                        service.deleteUser(username);
                        System.out.println();
                        System.out.println("*** User Deleted! ***");
                        System.out.println();
                    } catch (DataBaseServiceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "6":
                    User toBeRegistered = createUser();
                    try {
                        service.addUser(toBeRegistered);
                        System.out.println("----------------------");
                        System.out.println("*** User registered! ***");
                        System.out.println("----------------------");

                    } catch (DataBaseServiceException e) {
                        System.out.println(e.getMessage());
                    }
                case "7":
                    //EXIT
                    break;
                default:  System.out.println("Input not recognized");
                break;
            }
        }
    }

    //--------------------------------------------------------------------------------------------

    public static void menu() {
        System.out.println("[1] LOGIN");
        System.out.println("[2] REGISTER");
        System.out.println("[3] EXIT");
    }

    //--------------------------------------------------------------------------------------------

    public static void customerMenu() {
        System.out.println("[1] Show items list");
        System.out.println("[2] Buy items");
        System.out.println("[3] Deposit funds");
        System.out.println("[4] Logout");
    }

    //--------------------------------------------------------------------------------------------

    public static void adminMenu() {
        System.out.println("[1] Show items list");
        System.out.println("[2] Add items to the warehouse");
        System.out.println("[3] Remove item from the warehouse");
        System.out.println("[4] Show all users");
        System.out.println("[5] Remove user");
        System.out.println("[6] Add user");
        System.out.println("[7] Logout");
    }

    //--------------------------------------------------------------------------------------------

    private static User createUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Create username");
        String username = sc.nextLine().trim();
        System.out.println("Create password");
        String password = sc.nextLine().trim();
        System.out.println("Type in your name");
        String name = sc.nextLine().trim();
        System.out.println("Type in your last name");
        String surname = sc.nextLine().trim();
        String role = "customer";
        float balance = 500;

        return new User(username, password, name, surname, role, balance);
    }

    //--------------------------------------------------------------------------------------------

    private static Warehouse createItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Product name");
        String product = sc.nextLine();
        System.out.println("Product price");
        int price = sc.nextInt();
        System.out.println("Product quantity");
        int quantity = sc.nextInt();

        return new Warehouse(product, price, quantity);
    }




}
