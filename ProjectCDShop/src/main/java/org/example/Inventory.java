package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Inventory implements Iterable<StockableProduct> {
    private ArrayList<StockableProduct> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(StockableProduct item) {
        this.items.add(item);
    }

    public void removeItem(int productId) {
        items.removeIf(item -> item.getProductId() == productId);
    }

    public Product getItem(int productId) {
        for (StockableProduct item : items) {
            if (item.getProductId() == productId) {
                item.removeStock(1);
                return item;
            }
        }
        return null;
    }

    public void addProductStock(int productId, int number) {
        for (StockableProduct item : items) {
            if (item.getProductId() == productId) {
                item.addStock(number);
                break;
            }
        }
    }

    public void sortByPrice() {
        items.sort(Comparator.comparingDouble(StockableProduct::getPrice));
    }

    public void sortByAvailableStock() {
        items.sort(Comparator.comparingInt(StockableProduct::getNumberOfItemsStocked));
    }

    @Override
    public Iterator<StockableProduct> iterator() {
        return items.iterator();
    }
}
