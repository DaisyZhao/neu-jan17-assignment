package assignment5;

/**
 * @author Xueying Zhao
 */
public class Sundae extends IceCream {
    private String toppingName;
    private float costOfTopping;

    public Sundae(String name, float cost, String toppingName, float costOfTopping) {
        super(name, cost);
        this.toppingName = toppingName;
        this.costOfTopping = costOfTopping;
    }

    @Override
    public int getCost() {
        return Math.round(super.getCost() + costOfTopping);
    }

    @Override
    public String getName() {
        return String.format("%s Sundae with %s", toppingName, super.getName());
    }
}
