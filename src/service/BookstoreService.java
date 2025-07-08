package service;

import book.*;

public class BookstoreService {
    private Inventory inventory;

    public BookstoreService(Inventory inventory) {
        this.inventory = inventory; // Dependency Injection
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.getBook(isbn);
        if (book == null || !book.isPurchasable()) {
            throw new IllegalArgumentException("Quantum book store: Book not purchasable.");
        }

        if (book instanceof PaperBook) {
            ((PaperBook) book).reduceStock(quantity);
        }

        if (book instanceof Shippable) {
            ((Shippable) book).ship(address);
        }

        if (book instanceof Emailable) {
            ((Emailable) book).send(email);
        }

        double total = book.getPrice() * quantity;
        System.out.println("Quantum book store: Paid amount = " + total);
        return total;
    }
}
