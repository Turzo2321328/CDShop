package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Invoice {
    private ArrayList<Product> products;
    private Inventory inventory;

    public Invoice(Inventory inventory) {
        this.products = new ArrayList<>();
        this.inventory = inventory;
    }

    public String getLocalDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double calculatePriceWithoutDiscount() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public boolean isFullHouseDiscountAvailable() {
        Set<String> categories = new HashSet<>();
        for (Product product : products) {
            categories.add(product.getClass().getSimpleName());
        }
        return categories.size() == 3 && categories.stream().allMatch(cat -> products.stream().filter(p -> p.getClass().getSimpleName().equals(cat)).count() >= 2);
    }

    public double calculateDiscountedPrice() {
        double totalPrice = calculatePriceWithoutDiscount();
        double totalDiscount = products.stream().mapToDouble(p -> p.getPrice() * p.getDiscount()).sum();
        double priceAfterRegularDiscount = totalPrice - totalDiscount;
        double priceAfterFullHouseDiscount = isFullHouseDiscountAvailable() ? totalPrice * 0.5 : totalPrice;
        return Math.min(priceAfterRegularDiscount, priceAfterFullHouseDiscount);
    }

    public String getInvoice() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLocalDateTime()).append("\n");
        for (Product product : products) {
            sb.append("Name: ").append(product.getName()).append(", Price: ").append(product.getPrice()).append("\n");
        }
        sb.append("Total Price: ").append(calculatePriceWithoutDiscount()).append("\n");
        sb.append("Price after discount: ").append(calculateDiscountedPrice()).append("\n");
        return sb.toString();
    }
}
