// Lokesh Purohit (lpurohit1@toromail.csudh.edu)


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

abstract class Account implements Serializable {

    private static int accountNumberCounter = 1000;

    private String accountName;
    private Customer accountHolder;
    private boolean open = true;
    private final int accountNumber;
    //private double balance;

    private  ArrayList<Transaction> transactions;

    protected Account(String name, Customer customer) {

        transactions = new ArrayList<Transaction>();
        accountName = name;
        accountHolder = customer;
        accountNumber = ++accountNumberCounter;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Customer getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(Customer accountHolder) {
        this.accountHolder = accountHolder;
    }

    public boolean deposit(double amount) {
        if(isOpen()) {
            //balance+=amount;
            Transaction t = new Transaction("Credit", amount);
            transactions.add(t);
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        //balance -= amount;
        Transaction t = new Transaction("Debit", amount);
        transactions.add(t);
        return true;
    }

    public void close() {
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {    //Previously '==' operator was used instead of equals operator!!!  No difference in the output tho!
        double balance = 0;
        for (Transaction t : transactions) {
           balance = Objects.equals(t.getTransactionType(), "Credit") ? balance +
                   t.getTransactionValue() : balance - t.getTransactionValue();
        }
        return balance;
    }

    public String toString() {
        String aName = accountNumber + "(" + accountName + ")" + " : " + accountHolder.toString() + " : "
                + this.getBalance() + " : " + (isOpen()? "Open" : "Close");
        return aName;
    }

    public void printStatement() {
        for(Transaction t : transactions) {
            System.out.println("<" + t.getTransactionID() + "> : <" + t.getTransactionType() + "> : <" + t.getTransactionValue() + ">");
        }
        System.out.println("Balance:  <" + this.getBalance() + ">");
    }

}
