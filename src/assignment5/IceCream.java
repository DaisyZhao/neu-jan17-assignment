package assignment5;

/**
 * @author Xueying Zhao
 */
public class IceCream extends DessertItem {
    private float cost;

    public IceCream(float cost) {
        this.cost = cost;
    }

    public IceCream(String name, float cost) {
        super(name);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return Math.round(cost);
    }
}
