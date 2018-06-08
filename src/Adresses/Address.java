package Adresses;

public class Address {
    int idAdress;
    int idCustomer;
    String street;
    String county;
    String country;

    public Address(int idAdress, int idCustomer, String street, String county, String country) {
        this.idAdress = idAdress;
        this.idCustomer = idCustomer;
        this.street = street;
        this.county = county;
        this.country = country;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public String getStreet() {
        return street;
    }

    public String getCounty() {
        return county;
    }

    public String getCountry() {
        return country;
    }
}
