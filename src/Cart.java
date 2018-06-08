import Adresses.Address;
import Customers.Customer;
import Products.*;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Cart {

    private static CartTpl newCart = new CartTpl();
    private static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        //I transformed the Array List with all the products into a HashSet.
        //It will help me to eliminate the duplicates.

        Set<Products> uniqueItems = new HashSet<>(Catalog.getCatalog());
        Catalog.loopThroughCatalog(uniqueItems);
        System.out.println("- - - -  -- - - - - - - - -- - - -- - - - -- - - --  - - - -- - -- - - -- - - - - - - ");

        // The customer's menu. The next menu will give to the customer a friendly  interface of the store.

        int value = 0;
        boolean quit = true;
        showMenu();
        while (quit) {
            System.out.println("Enter your choise: ");
            value = scan.nextInt();
            scan.nextLine();
            switch (value) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showCart();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    showInvoice();
                    break;
                case 5:
                    Catalog.loopThroughCatalog(uniqueItems);
                    break;
                case 6:
                    quit = false;
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.println(" MENU \n" +
                "...you have to press one of the following buttons. \n\n"+

                "1. Add a product to your cart. \n" +
                "2. Show products from your Cart.\n" +
                "3. Remove an item from your Cart. \n" +
                "4. Print out the invoice.\n" +
                "5. Show catalog with products.\n" +
                "6. Quit!"
        );
    }

    public static void addProduct() {
        String name;
        int quantity;
        System.out.println("What product would you like to add to your cart?");
        System.out.println("You have to enter the name of the product: ");
        System.out.println("Eg: Monitor, SSD, Cellphone");
        name = scan.nextLine();
        System.out.println("What quantity?");
        quantity = scan.nextInt();
        newCart.findProduct(name, quantity);
    }

    public static void showCart() {
        newCart.showCartItems();
    }

    public static void remove() {
        if (newCart.numbersOfItemsInCart()) {
            removeItem();
        } else {
            System.out.println("You don't have any items to remove.\nThere are 0 items in your cart .");
        }
    }

    public static void removeItem() {
        System.out.println("What item would you like to remove from your Cart?");
        String item = scan.nextLine();
        newCart.removeProduct(item);
    }

    public static void showInvoice() {
        if (newCart.numbersOfItemsInCart()) {
            invoice();
        } else {
            System.out.println("You haven't added any items to your Cart. \nPress 1 to add some items to your cart.");
        }
    }


    /*
    I just supposed that I extracted the information about the customer from a database through a query.
    Also, this customer has the cart called newCart. I avoided the extend this requirement to much because
    I wouldn't have finished this project in time. :))
    */

    public static void invoice() {
        System.out.println("                INVOICE No. 01    \n\n");
        Customer customer1 = new Customer(1, "Ioan", "Popescu", "1900707234564");
        Address address1 = new Address(1, 1, "Teilor, 19", "Iasi", "Romania");
        System.out.printf("TO: %s, %s, CNP %s \n", customer1.getFirstName(), customer1.getLastName(), customer1.getCnp());
        System.out.printf("Domiciled on: Street %s, %s, %s \n", address1.getStreet(), address1.getCounty(), address1.getCountry());
        System.out.println("FROM: ONLINE STORE, street Titu Maiorescu, 12, Iasi, Romania");
        newCart.showCartItems();
    }


}
