import Products.*;

import java.util.ArrayList;

public class CartTpl {


    ArrayList<Products> catalog = Catalog.getCatalog();

    //"cartArray" is the  list with the products from cart.

    ArrayList<Products> cartArray = new ArrayList<>();

    //In the Array List "quantities" are shown the quantities ordered.
    ArrayList<Integer> quantities = new ArrayList<>();

    //The next method receive the product from the method "findProduct" and adds it in the cart.
    public void addItem(Products p) {
        cartArray.add(p);
        System.out.printf("The product %s has been added.\n", p.getName());
    }

    //Adds the quantity ordered by the customer in an ArrayList.

    public void addQuantity(int quantity) {
        quantities.add(quantity);
    }

    //The next method checks if a certain item exists in the catalog.

    public boolean findProduct(String name, int quantity) {
        for (int i = 0; i < catalog.size(); i++) {
            //Checks if the items exists and the stock is greater than the quantity ordered.
            if (name.equals(catalog.get(i).getName()) && catalog.get(i).getStock() >= quantity) {
                //Checks if the item exists in Cart.
                if (!existsInCart(name)) {
                    //If the item doesn't exist in cart it sends the quantity ordered to the method "addQuantity"
                    addItem(catalog.get(i));
                    addQuantity(quantity);
                    //Decreases the stock with the quantity ordered by customer.
                    catalog.get(i).updateStock(quantity);
                    return true;
                }
                    else {
                    System.out.printf("You have already added the product '%s' to your Cart.", name);
                    break;
                }
            }
        }
        System.out.println("The product does not exist or the stock is finished.");
        return false;
        }

        //The method existsInCart() checks if a certain item exists in cart.

    public boolean existsInCart(String name) {
        for (int i = 0; i < cartArray.size(); i++) {
            if (name.equals(cartArray.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    //The next method is used to delete the items from cart.

    public void removeProduct(String name) {
        for (int i = 0; i < cartArray.size(); i++) {
            if (name.equals(cartArray.get(i).getName())) {
                cartArray.remove(cartArray.get(i));
                quantities.remove(quantities.get(i));
                System.out.printf("The product %s has been deleted from your cart.\n Press number 4 to see your invoice.", name);
                break;
            } else {
                System.out.printf("You don't have the product %s in your cart", name);
            }
        }
    }

    //This method displays the items from the customer's cart.

    public void showCartItems() {
        double totalGeneral = 0;
        double totalDiscount = 0;
        System.out.println("\nPRODUCTS\n");
        for (int i = 0; i < cartArray.size(); i++) {
            double totalLine = cartArray.get(i).getFinalPrice() * quantities.get(i);
            totalDiscount = totalDiscount + (quantities.get(i) * cartArray.get(i).getDiscount());
            totalGeneral = totalLine + totalGeneral;
            System.out.println(cartArray.get(i).getName() + " =>  Quantity: " + quantities.get(i) + ", Price: "
                    + cartArray.get(i).getPrice() + ", Discount: "
                    + cartArray.get(i).getDiscount() + ", Total Line: " + totalLine);

        }

        System.out.println("\nTotal Discount: " + totalDiscount);
        System.out.println("Total General: " + totalGeneral);
        System.out.println("");
        System.out.println("Press 3 to remove an item from your cart.");
        System.out.println("Press 1 to add another item to your cart.");
    }

    // Checks if there are any items in cart.

    public boolean numbersOfItemsInCart() {
        int count = 0;
        for (int i = 0; i < cartArray.size(); i++) {
            count++;
            if (count > 0) {
                return true;
            }
        }
        return false;
    }
}
