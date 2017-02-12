package assignment4;

/**
 * @author Xueying Zhao
 */
public class GasTank {
    public double gasAmount;

    public GasTank() {
        this.gasAmount = 0;
    }

    public void addGas(double addAmount) {
        this.gasAmount += addAmount;
    }

    public void useGas(double useAmount) throws InsufficientGasException {
        if (this.gasAmount >= useAmount) {
            this.gasAmount -= useAmount;
        } else {
            throw new InsufficientGasException();
        }
    }
    public double getGasLevel() {
        return gasAmount;
    }

    public class InsufficientGasException extends Exception {}
}
