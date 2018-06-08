package Discount;

import Products.Products;

public class FixedDiscount extends Discount{
    @Override
    public double CalculateDiscount(Products product) {
        double discount = 100; // 100 lei discount.
        return discount;
    }
}
