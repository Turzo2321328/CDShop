package org.example;

class Game extends StockableProduct {
    public Game(int productId, String name, double price, double discount, int numberOfItemsStocked) {
        super(productId, name, price, discount, numberOfItemsStocked);
    }

    @Override
    public String getInfo() {
        return "Game: " + getName() + ", Price: " + getPrice() + ", Discount: " + getDiscount() + ", Stock: " + getNumberOfItemsStocked();
    }
}