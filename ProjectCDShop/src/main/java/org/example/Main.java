package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Game g1 = new Game(1, "Red Dead Redemption 2", 29.0, 0.05, 10);
        Game g2 = new Game(2, "God of War", 12.0, 0.1, 5);
        Music m1 = new Music(3, "Submarine", 20.0, 0.15, 20);
        Music m2 = new Music(4, "AM", 10.0, 0.1, 15);
        Movie v1 = new Movie(5, "Good Will Hunting", 12.0, 0.2, 7);
        Movie v2 = new Movie(6, "Life Is Beautiful", 20.0, 0.05, 10);

        inventory.addItem(g1);
        inventory.addItem(g2);
        inventory.addItem(m1);
        inventory.addItem(m2);
        inventory.addItem(v1);
        inventory.addItem(v2);

        // Print Inventory
        for (StockableProduct item : inventory) {
            System.out.println(item.getInfo());
        }

        // Create an invoice and add products
        Invoice invoice = new Invoice(inventory);
        invoice.addProduct(m1);
        invoice.addProduct(m2);
        invoice.addProduct(v1);
        invoice.addProduct(v2);
        invoice.addProduct(g1);

        // Print the invoice
        System.out.println(invoice.getInvoice());

        // Create another invoice and add products
        Invoice invoice2 = new Invoice(inventory);
        invoice2.addProduct(m1);
        invoice2.addProduct(m2);
        invoice2.addProduct(v1);
        invoice2.addProduct(v2);
        invoice2.addProduct(g1);
        invoice2.addProduct(g2);

        // Print the invoice
        System.out.println(invoice2.getInvoice());

        // Find available games
        System.out.println("Available games:");
        for (StockableProduct item : inventory) {
            if (item instanceof Game) {
                System.out.println(item.getName());
            }
        }

        // Find the cheapest available music album
        inventory.sortByPrice();
        for (StockableProduct item : inventory) {
            if (item instanceof Music) {
                System.out.println("Cheapest Music Album: Name: " + item.getName() + ", Price: " + item.getPrice());
                break;
            }
        }

        // Find all movies directed by "Francis Ford Coppola"
        System.out.println("Movies directed by Francis Ford Coppola:");
        for (StockableProduct item : inventory) {
            if (item instanceof Movie && item.getInfo().contains("Francis Ford Coppola")) {
                System.out.println(item.getName());
            }
        }
    }
}
