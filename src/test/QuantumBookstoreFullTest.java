package test;
import book.*;
import service.*;

public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        BookstoreService service = new BookstoreService(inventory);

        // Add books
        PaperBook paperBook = new PaperBook("111", "Java Mastery", "Sara Ahmed", 2018, 100.0, 10);
        EBook ebook = new EBook("222", "Clean Code", "abdo", 2020, 50.0, "PDF");
        DemoBook demo = new DemoBook("333", "Preview AI", "sara mohamed", 2015);
        DemoBook demo2 = new DemoBook("444", ".net", "sara mohamed", 2014);

        inventory.addBook(paperBook);
        inventory.addBook(ebook);
        inventory.addBook(demo);
        inventory.addBook(demo2);
        // Remove outdated books
        inventory.removeOutdatedBooks(7);

        // Valid test cases
        service.buyBook("111", 2, "user@example.com", "Cairo, Egypt"); // PaperBook
        service.buyBook("222", 1, "reader@ebook.com", "");            // EBook

        // Invalid test case demo book
        try {
            service.buyBook("333", 1, "demo@fail.com", "");
        } catch (Exception e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }

        // Invalid test case unknown ISBN
        try {
            service.buyBook("999", 1, "fake@fail.com", "NoWhere");
        } catch (Exception e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }

        // Invalid test case out of stock
        try {
            service.buyBook("111", 20, "bulk@fail.com", "Overstock City");
        } catch (Exception e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }

        // Edge case: buying remaining stock
        service.buyBook("111", 8, "final@buyer.com", "Final Destination");

        // Try to buy again stock now 0
        try {
            service.buyBook("111", 1, "fail@again.com", "Nowhere");
        } catch (Exception e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }
    }

}
