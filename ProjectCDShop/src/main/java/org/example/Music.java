package org.example;

class Music extends StockableProduct {
    public Music(int productId, String name, double price, double discount, int numberOfItemsStocked) {
        super(productId, name, price, discount, numberOfItemsStocked);
    }

    @Override
    public String getInfo() {
        return "Music: " + getName() + ", Price: " + getPrice() + ", Discount: " + getDiscount() + ", Stock: " + getNumberOfItemsStocked();
    }
}