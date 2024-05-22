package org.example;

abstract class Product {
    private int productId;
    private String name;
    private double price;
    private double discount;

    public Product(int productId, String name, double price, double discount) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public abstract String getInfo();
}
