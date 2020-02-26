public class Item {
    protected final Product product;
    protected int quantity;
    protected String unit;

    public Item(Product product) {
        this.product = product;
        this.quantity = 0;
        this.unit = "";
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    @Override
    public String toString() {
        return quantity + " " + unit + " of " + product;
    }
}
