// Lokesh Purohit (lpurohit1@toromail.csudh.edu)

import java.io.Serializable;

public class SavingAccount extends Account implements Serializable {

    public SavingAccount(Customer accountHolder) {
        super("Saving", accountHolder);
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance()-amount < 0) {
            return false;
        } else {
            return super.withdraw(amount);
        }
    }

    @Override
    public boolean deposit(double amount) {
        return super.deposit(amount);
    }

    /*@Override                             // Was tried to separate balances of all accounts. Made no difference!
    public double getBalance() {
        return super.getBalance();
    }*/
}

