package Products;

public class Monitor extends Products {
    static int stock = 0;

    public Monitor(int id, String name, String color, double price, String category) {
        super(id, name, color, price, category);
        stock++;
    }

    public int getStock() {
        return stock/2;
    }

    @Override
    public int updateStock(int soldQuantity) {
        stock = stock - soldQuantity;
        return stock;
    }



}
