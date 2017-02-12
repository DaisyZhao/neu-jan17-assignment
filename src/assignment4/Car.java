package assignment4;

/**
 * @author Xueying Zhao
 */
public class Car {
    private String carName;
    private String size;
    private boolean isAuto;
    private double mileage;
    private double mpg;
    private GasTank gasTank;

    public Car(String carName, String size, boolean isAuto, double mileage, double mpg) {
        this.carName = carName;
        this.size = size;
        this.isAuto = isAuto;
        this.mileage = mileage;
        this.mpg = mpg;
        this.gasTank = new GasTank();
    }

    public void run(double miles) throws GasTank.InsufficientGasException {
        gasTank.useGas(miles / mpg);
        mileage += miles;
    }

    public void addGas(double addAmount) {
        gasTank.addGas(addAmount);
    }

    public String getCarName() {
        return carName;
    }

    public String getSize() {
        return size;
    }

    public boolean isAuto() {
        return isAuto;
    }

    public double getMpg() {
        return mpg;
    }

    public double getMileage() {
        return mileage;
    }

    public double getGasLevel() {
        return gasTank.getGasLevel();
    }
}
