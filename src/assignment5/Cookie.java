package assignment5;

/**
 * @author Xueying Zhao
 */
public class Cookie extends DessertItem {
    private int number;
    private int pricePerDozen;

    public Cookie(String name, int number, int pricePerDozen) {
        super(name);
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    public int getNumber() {
        return number;
    }

    public int getPricePerDozen() {
        return pricePerDozen;
    }

    @Override
    public int getCost() {
        return Math.round(pricePerDozen * number / 12);
    }
}
