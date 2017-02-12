package assignment4;

import org.junit.Test;

/**
 * Created by zhaoxueying on 2/12/17.
 */
public class CarTest {
    @Test
    public void testAddGas() {
        Car car = new Car("Ford","compact",false, 0, 10);
        car.addGas(10);
        assert car.getGasLevel() == 10;
    }
    @Test
    public void testRun() throws GasTank.InsufficientGasException {
        Car car = new Car("Ford","compact",false, 0, 10);
        car.addGas(10);
        car.run(20);
        assert car.getGasLevel() == 8;
    }
}
