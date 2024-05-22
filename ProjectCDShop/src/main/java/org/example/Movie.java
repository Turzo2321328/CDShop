package org.example;

class Movie extends StockableProduct {
    public Movie(int productId, String name, double price, double discount, int numberOfItemsStocked) {
        super(productId, name, price, discount, numberOfItemsStocked);
    }

    @Override
    public String getInfo() {
        return "Movie: " + getName() + ", Price: " + getPrice() + ", Discount: " + getDiscount() + ", Stock: " + getNumberOfItemsStocked();
    }
}