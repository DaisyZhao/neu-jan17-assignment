package assignment4;

/**
 * @author Xueying Zhao
 */
public class Driver {
    private String driverName;
    Car carOfDriver;

    public Driver(String driverName, Car carOfDriver) {
        this.driverName = driverName;
        this.carOfDriver = carOfDriver;
    }

    public void drive(double miles) {
        try {
            carOfDriver.run(miles);
        } catch (GasTank.InsufficientGasException e) {
            System.out.println("Insufficient gas to drive!");
        }
    }

    public void addGas(double addAmount) {
        carOfDriver.addGas(addAmount);
    }

    public String getDriverName() {
        return driverName;
    }

    public Car getCarOfDriver() {
        return carOfDriver;
    }

}
