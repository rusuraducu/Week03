package Customers;

public class Customer {
    int idCustomer;
    String firstName;
    String lastName;
    String cnp;
    String cart;

    public Customer(int id, String firstName, String lastName, String cnp) {
        this.idCustomer = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.cart = cart;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public String getCart() { return cart; }
}
