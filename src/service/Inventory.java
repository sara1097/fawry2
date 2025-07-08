package service;

import book.*;

import java.util.*;

public class Inventory {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Book added - " + book.getTitle());
    }

    public Book removeBook(String isbn) {
        return books.remove(isbn);
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    public List<Book> removeOutdatedBooks(int maxAge) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Book> removed = new ArrayList<>();

        Iterator<Map.Entry<String, Book>> iterator = books.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();
            if (currentYear - book.getYear() > maxAge) {
                removed.add(book);
                System.out.println("Quantum book store: Removed outdated book - " + book.getTitle());
                iterator.remove();
            }
        }

        return removed;
    }
}
