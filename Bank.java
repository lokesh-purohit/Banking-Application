// Lokesh Purohit (lpurohit1@toromail.csudh.edu)

import java.io.*;
import java.util.ArrayList;

public class Bank implements Serializable {

    private static ArrayList<Account> accounts = new ArrayList<Account>();

    private static String file="C:\\Users\\Loky\\IdeaProjects\\CSC123_Assignment7_BankingApplication\\src\\Data.txt";
    /*public static Account openAccount(String firstName, String lastName, String ssn, String accountName) {

        Customer c = new Customer(firstName, lastName, ssn);
        Account a = new Account(accountName, c);
        accounts.add(a);
        return a;
    }*/

    public static Account openCheckingAccount(String firstName, String lastName, String ssn, double overDraftLimit) {

        Customer c = new Customer(firstName, lastName, ssn);
        Account a = new CheckingAccount(c, overDraftLimit);
        accounts.add(a);
        return a;
    }

    public static Account openCreditCardAccount(String firstName, String lastName, String ssn, double creditLimit) {

        Customer c = new Customer(firstName, lastName, ssn);
        Account a = new CreditCardAccount(c, creditLimit);
        accounts.add(a);
        return a;
    }

    public static Account openSavingAccount(String firstName, String lastName, String ssn) {

        Customer c = new Customer(firstName, lastName, ssn);
        Account a = new SavingAccount(c);
        accounts.add(a);
        return a;
    }

    public static void save() throws IOException{
        ObjectOutputStream oos=null;
        FileOutputStream fos=null;
        try {

            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(Bank.accounts);

        }
        finally{
            if(oos!=null)oos.close();
            if(fos!=null)fos.close();

        }

    }

    public static void load() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=null;
        FileInputStream fis=null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            accounts = (ArrayList<Account>) ois.readObject();
            ois.close();
            fis.close();
        }
        finally{
            if(ois!=null)ois.close();
            if(fis!=null)fis.close();
        }
    }

    public static Account lookup(int accountNumber) {
        for (Account a:accounts) {
            if (a.getAccountNumber() == accountNumber) {
                return a;
            }
        }
        return null;
    }

    public static void listAccounts() {
        for (Account a:accounts) {
            System.out.println(a);
        }
    }
}

