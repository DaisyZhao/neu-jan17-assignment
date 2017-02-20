package assignment5;

import java.util.ArrayList;

/**
 * @author Xueying Zhao
 */
public class Checkout {
    private ArrayList<DessertItem> dessertItems = new ArrayList<>();

    public Checkout() {
    }

    public int numberOfItems() {
        return dessertItems.size();
    }

    public void enterItem(DessertItem item) {
        dessertItems.add(item);
    }

    public void clear() {
        dessertItems.clear();
    }

    public int totalCost() {
        int totalCost = 0;
        for (int i = 0; i < numberOfItems(); i++) {
            totalCost += dessertItems.get(i).getCost();
        }
        return totalCost;
    }

    public int totalTax() {
        return Math.round(totalCost() * DessertShoppe.taxRate);
    }

    public String toString() {
        String output = "";

        // output store name and line
        int spaceNumber = DessertShoppe.maxCostDisplay + DessertShoppe.maxItemDisplay - DessertShoppe.storeName.length();
        for (int i = 0; i < spaceNumber / 2; i++) {
            output += " ";
        }
        output += DessertShoppe.storeName + "\n";
        for (int i = 0; i < spaceNumber / 2; i++) {
            output += " ";
        }
        for (int i = 0; i < DessertShoppe.storeName.length(); i++) {
            output += "-";
        }
        output += "\n\n";

        // output every dessert items
        for (int i = 0; i < numberOfItems(); i++) {
            DessertItem item = dessertItems.get(i);
            if (item.getClass().equals(Candy.class)) {
                output += ((Candy) item).getWeight() + " lbs. @ "
                        + DessertShoppe.cents2dollarsAndCents(((Candy) item).getPricePerPound()) + " /1b." + "\n";

            } else if (item.getClass().equals(Cookie.class)) {
                output += ((Cookie) item).getNumber() + " @ "
                        + DessertShoppe.cents2dollarsAndCents(((Cookie) item).getPricePerDozen()) + " /dz." + "\n";
            }

            // output name of each item
            String[] str = item.getName().split(" ");
            int display = 0;

            for (int j = 0; j < str.length; j++) {
                display += str[j].length() + 1;
                if (display <= DessertShoppe.maxItemDisplay) {
                    output += str[j] + " ";
                } else {
                    output += "\n" + str[j] + " ";
                    display = str[j].length() + 1;
                }
            }

            // output cost of each item
            String costStr = String.valueOf(DessertShoppe.cents2dollarsAndCents(item.getCost()));
            if (costStr.length() < DessertShoppe.maxCostDisplay) {
                for (int j = 0; j < (DessertShoppe.maxCostDisplay + DessertShoppe.maxItemDisplay - costStr.length()
                        - display); j++) {
                    output += " ";
                }
                output += costStr + "\n";
            }
        }

        // output tax  and total cost of all items
        output += "\n" + "Tax";
        String str = String.valueOf(DessertShoppe.cents2dollarsAndCents(totalTax()));
        for (int i = 0; i < (DessertShoppe.maxCostDisplay + DessertShoppe.maxItemDisplay - 3 - str.length()); i++) {
            output += " ";
        }
        output += str + "\n" + "Total Cost";
        String totalStr = String.valueOf(DessertShoppe.cents2dollarsAndCents(totalTax() + totalCost()));
        for (int i = 0; i < (DessertShoppe.maxCostDisplay + DessertShoppe.maxItemDisplay - 10 - totalStr.length()); i++) {
            output += " ";
        }
        output += totalStr + "\n";

        return output;
    }

}
