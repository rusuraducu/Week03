package Discount;
import Products.*;


public class PercentageDiscount extends Discount{
    double rateOfDiscount = 0.05; //5% discount

    @Override
    public double CalculateDiscount(Products product) {
        return rateOfDiscount;
    }
}
