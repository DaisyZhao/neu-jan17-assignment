package assignment4;

import org.junit.Test;

/**
 * Created by zhaoxueying on 2/12/17.
 */
public class GasTankTest {
    @Test
    public void testAddGasAndUseGas() throws GasTank.InsufficientGasException {
        GasTank gasTank = new GasTank();
        gasTank.addGas(100);
        assert gasTank.getGasLevel() == 100;
        gasTank.useGas(80);
        assert gasTank.getGasLevel() == 20;
    }
}
