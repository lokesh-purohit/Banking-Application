// Lokesh Purohit (lpurohit1@toromail.csudh.edu)


import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {

    private String firstName;
    private String lastName;
    private String ssn;

    public Customer(String fName, String lName, String socialNum) {
        firstName = fName;
        lastName = lName;
        ssn = socialNum;
    }

    public Customer() {}

    public Customer(Customer p) {
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.ssn = p.getSsn();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lName) {
        lastName = lName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String socialNum) {
        ssn = socialNum;
    }

    public String toString() {
        return firstName + " : " + lastName + " : " + ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && ssn.equals(customer.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, ssn);
    }
}
