package assignment6;

/**
 * Created by luqifei on 2/19/17.
 */
public class Account {
    // instance data members
    protected String firstName, lastName; // two String members
    protected double curBalance;

    // methods
    public Account(String fname, String lname, double cb) {
        firstName = fname;
        lastName = lname;
        curBalance = cb;
    }

    public String getAcctType() {
        return this.getClass().getName(); // returns the string of the class name
    }

    public double debitTransaction(double debitAmount) {
        curBalance -= debitAmount;
        return curBalance;
    }

    public double creditTransaction(double creditAmount) {
        curBalance += creditAmount;
        return curBalance;
    }

    public String toString() {
        return "Account name: " + firstName + " " + lastName + ", Account Type: " + getAcctType() + ", Balance: " + String.format("$%.2f", curBalance);
    }

    // Simple Unit Test
    public static void main(String[] args) {
        Account ac1 = new Account("John", "Smith", 100);
        System.out.println(ac1);

        ac1.debitTransaction(30.25); // should be $69.75
        System.out.println(ac1);

        ac1.creditTransaction(10.10);
        System.out.println(ac1); // should be $79.85
    }

  /* Output of the unit test

  Account name: John Smith, Account Type: Account, Balance: $100.00
  Account name: John Smith, Account Type: Account, Balance: $69.75
  Account name: John Smith, Account Type: Account, Balance: $79.85
  */

} // end class


