package assignment4;

import org.junit.Test;

/**
 * Created by zhaoxueying on 2/12/17.
 */
public class DriverTest {
    @Test
    public void testAddGasAndDrive() {
        Driver driver = new Driver("Daisy",
                new Car("Ford","compact",false, 0, 10));
        driver.addGas(10);
        assert driver.getCarOfDriver().getGasLevel() == 10;

        driver.drive(20);
        assert driver.getCarOfDriver().getGasLevel() == 8;

        driver.drive(40);
        assert driver.getCarOfDriver().getGasLevel() == 4;
    }
}
