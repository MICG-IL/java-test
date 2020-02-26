public class Item {
    protected final Product product;
    protected int quantity;
    protected String unit;
    protected double price;

    public Item(Product product) {
        this.product = product;
        this.quantity = 0;
        this.unit = "";
        this.price = 0;
    }

    public void incrementQuantity(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return quantity + " " + unit + " of " + product;
    }

    public double getTotal() {
        return price * quantity;
    }
}
