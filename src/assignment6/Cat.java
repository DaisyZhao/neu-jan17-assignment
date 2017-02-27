package assignment6;

import java.util.Calendar;

/**
 * @author Xueying Zhao
 */
public class Cat extends Pet implements Boardable{
    private String hairLength;
    private Calendar startDate = Calendar.getInstance();
    private Calendar endDate = Calendar.getInstance();

    public Cat(String petName, String ownerName, String color, String hairLength) {
        super(petName, ownerName, color);
        this.hairLength = hairLength;
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

    public String getHairLength() {
        return hairLength;
    }

    public String toString() {
        return "CAT: \n" + super.toString() + "Hair: " + getHairLength() + "\n";
    }

    public static void main(String args[]) {
        Cat cat1 = new Cat("Tom", "Bob", "black", "short");
        cat1.setSex(2);
        cat1.setBoardStart(2, 26, 2016);
        cat1.setBoardEnd(10,26, 2016);

        System.out.println(cat1);
        System.out.println(cat1.boarding(5,1, 2016));
    }

}
