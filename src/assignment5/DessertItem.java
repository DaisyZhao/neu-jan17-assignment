package assignment5;

/**
 * @author Xueying Zhao
 */
public abstract class DessertItem {
    protected String name;

    public DessertItem() {
    }

    public DessertItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getCost();

}
