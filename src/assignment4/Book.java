package assignment4;

/**
 * @author Xueying Zhao
 */
public class Book {
    private String bookTitle;
    private float price;

    public Book(String bookTitle, float price) {
        this.bookTitle = bookTitle;
        this.price = price;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public float getPrice() {
        return price;
    }
}
