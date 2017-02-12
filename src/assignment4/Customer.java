package assignment4;

import java.util.ArrayList;

/**
 * @author Xueying Zhao
 */
public class Customer {
    private String customerName;
    ArrayList<Book> books = new ArrayList<>();

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void purchaseBook(Book book) {
        books.add(book);
    }

    public float evaluateTotalPrice() {
        float totalPrice = 0;
        for (int i = 0; i < books.size(); i++) {
            totalPrice += books.get(i).getPrice();
        }
        return totalPrice;
    }

}
