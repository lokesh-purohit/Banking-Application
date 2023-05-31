// Lokesh Purohit (lpurohit1@toromail.csudh.edu)

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner KB = new Scanner(System.in);

        int choice;

        try {
            Bank.load();
        }

        catch (Exception ignored) {
            ignored.printStackTrace();
            System.out.println("Warning: Account data could not be loaded!");
        }


        while(true) {
            do {
                System.out.println("1 – Open Checking account\n" +
                        "2 – Open Saving Account\n" +
                        "3 – Open Credit Card Account\n" +
                        "4 – List Accounts\n" +
                        "5 – Account Statement\n" +
                        "6 – Deposit funds\n" +
                        "7 – Withdraw funds\n" +
                        "8 – Close an account\n" +
                        "9 – Exit\n" +
                        "Please enter your choice:");
                choice = KB.nextInt();

            } while (choice < 1 || choice > 9);

            if (choice == 1) {

                System.out.println("Enter first name: ");
                String firstName = KB.next();

                System.out.println("Enter last name: ");
                String lastName = KB.next();

                System.out.println("Enter social security number: ");
                String socialNumber = KB.next();

                System.out.println("Enter overdraft limit: ");
                double overDraftLimit = KB.nextDouble();

                Account a = Bank.openCheckingAccount(firstName, lastName, socialNumber, overDraftLimit);

                System.out.println("Thank you, the account number is: " + a.getAccountNumber());

            } else if (choice == 2) {

                System.out.println("Enter first name: ");
                String firstName = KB.next();

                System.out.println("Enter last name: ");
                String lastName = KB.next();

                System.out.println("Enter social security number: ");
                String socialNumber = KB.next();

                Account a = Bank.openSavingAccount(firstName, lastName, socialNumber);

                System.out.println("Thank you, the account number is: " + a.getAccountNumber());

            } else if (choice == 3) {

                System.out.println("Enter first name: ");
                String firstName = KB.next();

                System.out.println("Enter last name: ");
                String lastName = KB.next();

                System.out.println("Enter social security number: ");
                String socialNumber = KB.next();

                System.out.println("Enter credit limit: ");
                double creditLimit = KB.nextDouble();

                Account a = Bank.openCreditCardAccount(firstName, lastName, socialNumber, creditLimit);

                System.out.println("Thank you, the account number is: " + a.getAccountNumber());

            } else if (choice == 4) {

                Bank.listAccounts();

            } else if (choice == 5) {

                System.out.println("Enter account number: ");
                int accNumber = KB.nextInt();

                if (Bank.lookup(accNumber) == null)
                    System.out.println("This account number doesn't exist!");
                else
                    Bank.lookup(accNumber).printStatement();

            } else if (choice == 6) {

                System.out.println("Enter account number: ");
                int accNumber = KB.nextInt();

                System.out.println("Enter the amount to deposit: ");
                double amount = KB.nextDouble();

                if (Bank.lookup(accNumber) == null) {
                    System.out.println("Account not found");
                } else {
                    Boolean reply = Bank.lookup(accNumber).deposit(amount);
                    if (reply) {
                        System.out.println("Deposit successful, the new balance is: " + Bank.lookup(accNumber).getBalance());
                    } else {
                        System.out.println("Deposit failed, the balance is: " + Bank.lookup(accNumber).getBalance());
                    }
                }

            } else if (choice == 7) {

                System.out.println("Enter account number: ");
                int accNumber = KB.nextInt();

                System.out.println("Enter the withdrawal amount: ");
                double amount = KB.nextDouble();

                if (Bank.lookup(accNumber) == null) {

                    System.out.println("Account not found");
                } else {

                    Boolean reply = Bank.lookup(accNumber).withdraw(amount);
                    if (reply) {
                        System.out.println("Withdrawal successful, the new balance is: " + Bank.lookup(accNumber).getBalance());
                    } else {
                        System.out.println("Withdrawal failed, the balance is: " + Bank.lookup(accNumber).getBalance());
                    }
                }

            } else if (choice == 8) {

                System.out.println("Enter account number to close: ");
                int accNumber = KB.nextInt();

                if (Bank.lookup(accNumber) == null) {

                    System.out.println("Account not found");
                } else {

                    Bank.lookup(accNumber).close();
                    System.out.println("Account closed, current balance is " + Bank.lookup(accNumber).getBalance()
                            + "," + (Bank.lookup(accNumber).getAccountName().equals("Credit Card")? " withdrawals " : " deposits ")
                            + "are no longer possible!");
                }

            } else if (choice == 9){

                FileOutputStream fos;
                ObjectOutputStream oos = null;

                try {
                        Bank.save();
                  }

            catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            catch (IOException ex) {
                ex.printStackTrace();
            }

                System.out.println("Thank you for using our service. Goodbye!");
                KB.close();
                System.exit(0);

            }
        }
    }
}