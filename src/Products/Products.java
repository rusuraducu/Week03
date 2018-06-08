package Products;

import java.util.Objects;

public abstract class Products {
    int id;
    String name;
    String color;
    public double  price;
    public String category;
    public double discount;
    public double finalPrice;

    public String getName() {
        return name;
    }

    public double getFinalPrice() {
        finalPrice = price - discount;
        return finalPrice;
    }

    public Products(int id, String name, String color, double price, String category) {
        this.id=id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "" +
                "" + id +
                ". " + name +
                " => Color: " + color +", "+
                " Price:  " + price+ " lei, "+
                " Category:  " + category +", "+
                " Discount:   " + discount +" lei , "+
                " Final Price:  " + finalPrice +" lei. "+
                " | | | Products in stock: => ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(name, products.name) &&
                Objects.equals(color, products.color) &&
                Objects.equals(price, products.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, color, price);
    }

    public double getPrice() {
        return price;
    }

    public abstract int getStock();

    public abstract int updateStock(int soldQuantity);

    public double getDiscount(){
        return discount;
    }
}
