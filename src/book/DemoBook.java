package book;

public class DemoBook extends Book  {
    public DemoBook(String isbn, String title, String author, int year) {
        super(isbn, title, author, year, 0);
    }

    @Override
    public boolean isPurchasable() {
        return false;
    }
}
