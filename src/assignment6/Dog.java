package assignment6;

import java.util.Calendar;

/**
 * @author Xueying Zhao
 */
public class Dog extends Pet implements Boardable{
    private String size;
    private Calendar startDate = Calendar.getInstance();
    private Calendar endDate = Calendar.getInstance();

    public Dog(String petName, String ownerName, String color, String size) {
        super(petName, ownerName, color);
        this.size = size;
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        this.startDate.set(year, month, day);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        this.endDate.set(year, month, day);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(year, month, day);

        return !currentDate.before(startDate) && !currentDate.after(endDate);
    }

    public String getSize() {
        return size;
    }

    public String toString() {
        return "DOG: \n" + super.toString() + "Size: " + getSize() + "\n";
    }

    public static void main(String args[]) {
        Dog dog1 = new Dog("Spot", "Susan", "white", "medium");
        dog1.setSex(2);
        dog1.setBoardStart(3, 1, 2016);
        dog1.setBoardEnd(12,31, 2018);

        System.out.println(dog1);
        System.out.println(dog1.boarding(12,31, 2018));
    }
}
