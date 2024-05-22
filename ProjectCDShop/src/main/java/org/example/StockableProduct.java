package org.example;

class StockableProduct extends Product implements Stockable {
    private int numberOfItemsStocked;

    public StockableProduct(int productId, String name, double price, double discount, int numberOfItemsStocked) {
        super(productId, name, price, discount);
        this.numberOfItemsStocked = numberOfItemsStocked;
    }

    @Override
    public void addStock(int quantity) {
        this.numberOfItemsStocked += quantity;
    }

    @Override
    public void removeStock(int quantity) {
        this.numberOfItemsStocked -= quantity;
    }

    @Override
    public void editStock(int quantity) {
        this.numberOfItemsStocked = quantity;
    }

    public int getNumberOfItemsStocked() {
        return numberOfItemsStocked;
    }

    @Override
    public String getInfo() {
        // To be implemented by subclasses
        return null;
    }
}
