package Discount;
import Products.*;
import java.util.ArrayList;

public class ApplyDiscount {
    public static void applyDiscount(ArrayList<Products> catalog) {

        Discount percentage = new PercentageDiscount();
        Discount fixedDiscount = new FixedDiscount();

        // Percentage discount for the products from Storage Devices.

        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).category.equals("Storage Devices")) {
                catalog.get(i).discount = percentage.CalculateDiscount(catalog.get(i) ) * catalog.get(i).getPrice();
                catalog.get(i).finalPrice = catalog.get(i).getPrice() - catalog.get(i).getDiscount();

                // Fixed Discount for the products from Mobile Phones.

            } else if (catalog.get(i).category.equals("Mobile Phones")) {

                catalog.get(i).discount = fixedDiscount.CalculateDiscount(catalog.get(i));
                catalog.get(i).finalPrice = catalog.get(i).getPrice() - catalog.get(i).getDiscount();

            } else {

                catalog.get(i).discount = 0;
                catalog.get(i).finalPrice = catalog.get(i).price;

            }
        }
    }
}
