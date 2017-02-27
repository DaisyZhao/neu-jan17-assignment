package assignment6;

import java.util.ArrayList;

/**
 * @author Xueying Zhao
 */
public class Mreview {
    private String title;
    private ArrayList<Integer> ratings;

    public Mreview() {
        this.title = "";
        this.ratings = new ArrayList<>();
    }

    public Mreview(String ttl) {
        this.title = ttl;
        this.ratings = new ArrayList<>();
    }

    public Mreview(String ttl, int firstRating) {
        this.title = ttl;
        this.ratings = new ArrayList<>();
        this.ratings.add(firstRating);
    }

    public void addRating(int r) {
        this.ratings.add(r);
    }

    public double aveRating() {
        double sum = 0;

        for (int i = 0; i < numRatings(); i++) {
            sum += ratings.get(i);
        }

        return sum / numRatings();
    }

    public int compareTo(Mreview obj) {
        return title.compareTo(obj.getTitle());
    }

    public boolean equals(Object obj) {
        if (title.equals(((Mreview) obj).getTitle())) {
            return true;
        } else {
            return false;
        }
    }

    public String getTitle() {
        return title;
    }

    public int numRatings() {
        return ratings.size();
    }

    public String toString() {
        String newStr = String.format("%s, average %.2f out of %d ratings", getTitle(), aveRating(), numRatings());
        return newStr;
    }


    public static void main(String args[]) {
        Mreview mreview = new Mreview("Kill Bill", 3);
        mreview.addRating(4);
        mreview.addRating(5);
        mreview.addRating(3);
        System.out.println(mreview);

        Mreview mreview1 = new Mreview("Titanic", 4);
        mreview1.addRating(5);

        Mreview mreview2 = new Mreview("Titanic", 3);
        mreview2.addRating(4);

        System.out.println(mreview.compareTo(mreview1));
        System.out.println(mreview1.equals(mreview2));
    }

}
