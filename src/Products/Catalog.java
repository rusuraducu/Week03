package Products;
import Discount.*;
import java.util.*;

public class Catalog {
    //This method get all the items from shop. The duplicates will not be eliminated.
    public static ArrayList<Products> getCatalog() {
        ArrayList<Products> catalog = getProducts();

        //Apply the discount.
        ApplyDiscount.applyDiscount(catalog);
        return catalog;
    }

    //The next method is going to be used for adding new items.

    public static ArrayList<Products> getProducts() {
        ArrayList<Products> catalog = new ArrayList<Products>();
        catalog.add(new SSD(1,"SSD", "red", 322, "Storage Devices"));
        catalog.add(new SSD(1,"SSD", "red", 322, "Storage Devices"));
        catalog.add(new SSD(1,"SSD", "red", 322, "Storage Devices"));
        catalog.add(new Cellphone(2,"Cellphone", "black", 545, "Mobile Phones"));
        catalog.add(new Cellphone(2,"Cellphone", "black", 545, "Mobile Phones"));
        catalog.add(new Cellphone(2,"Cellphone", "black", 545, "Mobile Phones"));
        catalog.add(new Cellphone(2,"Cellphone", "black", 545, "Mobile Phones"));
        catalog.add(new Monitor(3,"Monitor", "white", 900, "Computers"));
        catalog.add(new Monitor(3,"Monitor", "white", 900, "Computers"));
        catalog.add(new Monitor(3,"Monitor", "white", 900, "Computers"));
        catalog.add(new Monitor(3,"Monitor", "white", 900, "Computers"));

        return catalog;
    }

    /* This loop will be used by the HashSet called uniqueValues.
        The loop will show the catalog without duplicates.
    */
    public static void loopThroughCatalog(Set<Products> uniqueValue) {
        for (Products prod : uniqueValue) {
            System.out.println(prod.toString() + prod.getStock());
        }
    }
}