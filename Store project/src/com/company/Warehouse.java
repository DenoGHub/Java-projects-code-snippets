package com.company;

public class Warehouse {
    private String product;
    private int price;
    private int quantity;

    public Warehouse (String product, int price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public Warehouse() {

    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setPrice(int price) { this.price = price; }

    public String getProduct() { return product; }

    public int getPrice() { return price; }

    public int getQuantity() { return quantity; }

    public String getAllWarehouseItems() {
        return "Name: " + product + '\n' +
                "Price: " + price + '\n' +
                "Items in stock: " + quantity;
    }

    @Override
    public String toString() {
        return "Name: " + product + '\n' +
                "Price: " + price + '\n' +
                "Items in stock: " + quantity;
    }
}


