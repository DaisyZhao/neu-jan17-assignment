package assignment4;

import org.junit.Test;

/**
 * Created by zhaoxueying on 2/11/17.
 */
public class CustomerTest {
    @Test
    public void testCustomer() {
        Customer customer1 = new Customer("Tom");
        customer1.purchaseBook(new Book("Head First Java", 58.20f));
        customer1.purchaseBook(new Book("Database",25.10f));
        assert customer1.evaluateTotalPrice() == 83.30f;
    }
}
