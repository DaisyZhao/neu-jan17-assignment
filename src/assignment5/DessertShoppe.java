package assignment5;

/**
 * @author Xueying Zhao
 */
public class DessertShoppe {
    public static final float taxRate = 0.0646f;
    public static final String storeName = "M & M Dessert Shoppe";
    public static final int maxItemDisplay = 25;
    public static final int maxCostDisplay = 11;

    public static String cents2dollarsAndCents(int cents) {
        return String.format("%.2f", (float) cents / 100);
    }
}
