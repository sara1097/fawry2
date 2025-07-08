package book;

public abstract class Book {
    protected String isbn, title, author;
    protected int year;
    protected double price;

    public Book(String isbn, String title, String author, int year, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public String getIsbn() { return isbn; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public String getTitle() { return title;}

   // public abstract void deliver(String email, String address);
    public abstract boolean isPurchasable();

    //public abstract void send(String email);
}
