// Lokesh Purohit (lpurohit1@toromail.csudh.edu)

import java.io.Serializable;

public class Transaction implements Serializable {

    private static long transactionCounter = 10000;

    private String transactionType;
    private double transactionValue;

    private final long transactionID;

    public Transaction(String transactionType, double transactionValue) {

        transactionID = ++transactionCounter;
        this.transactionType = transactionType;
        this.transactionValue = transactionValue;
    }

    public long getTransactionID() {
        return transactionID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getTransactionValue() {
        return transactionValue;
    }
}
