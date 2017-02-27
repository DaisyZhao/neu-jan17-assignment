package assignment6;

/**
 * @author Xueying Zhao
 */
public class Pet {
    private String petName;
    private String ownerName;
    private String color;
    protected int sex;
    private static final int MALE = 0;
    private static final int FEMALE = 1;
    private static final int SPAYED = 2;
    private static final int NEUTERED = 3;

    public Pet(String petName, String ownerName, String color) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.color = color;
    }

    public void setSex(int sexid) {
        if (sexid >= 0 && sexid <= 3) {
            this.sex = sexid;
        } else {
            throw new IllegalArgumentException("illegal argument");
        }
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public String getSex() {
        if(sex == MALE) {
            return "male";
        } else if (sex == FEMALE) {
            return "female";
        } else if (sex == SPAYED) {
            return "spayed";
        } else {
            return "neutered";
        }
    }

    public String toString() {
        return getPetName() + " owned by " + getOwnerName() + "\nColor: " + getColor() + "\nSex: " + getSex() + "\n";
    }
}
