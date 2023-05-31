// Lokesh Purohit (lpurohit1@toromail.csudh.edu)

import java.io.Serializable;

public class CheckingAccount extends Account implements Serializable {

    private double overDraftLimit;

    public CheckingAccount(Customer accountHolder, Double overdraftLimit) {
        super("Checking", accountHolder);
        this.overDraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw (double amount) {
        if (getBalance() + overDraftLimit - amount < 0) {
            return false;
        } else {
            return super.withdraw(amount);
        }
    }


    @Override
    public boolean deposit(double amount) {
        return super.deposit(amount);
    }

    /*@Override                         // Was tried to separate balances of all accounts. Made no difference!
    public double getBalance() {
        return super.getBalance();
    }*/

    public double getOverDraftLimit() {
        return overDraftLimit;
    }

    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }
}

