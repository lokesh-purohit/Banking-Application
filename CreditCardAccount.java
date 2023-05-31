// Lokesh Purohit (lpurohit1@toromail.csudh.edu)

import java.io.Serializable;

public class CreditCardAccount extends Account implements Serializable {

    private double creditLimit;

    public CreditCardAccount(Customer c, double creditLimit) {
        super("Credit Card", c);
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() + amount > creditLimit) {
            return false;
        } else {
            return super.deposit(amount);
        }
    }

    @Override
    public boolean deposit(double amount) {
        return super.withdraw(amount);
    }

    /*@Override                         // Was tried to separate balances of all accounts. Made no difference!
    public double getBalance() {
        return super.getBalance();
    }*/

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}

