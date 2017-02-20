package assignment5;

/**
 * @author Xueying Zhao
 */
public class Candy extends DessertItem {
    private float weight;
    private int pricePerPound;

    public Candy(String name, float weight, int pricePerPound) {
        super(name);
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    public float getWeight() {
        return weight;
    }

    public int getPricePerPound() {
        return pricePerPound;
    }

    @Override
    public int getCost() {
        return Math.round((weight * pricePerPound));
    }
}
