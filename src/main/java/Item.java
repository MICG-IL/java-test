public class Item {
    protected final String product;
    protected int quantity;
    protected String unit;

    public Item(String product) {
        this.product = product;
        this.quantity = 0;
        this.unit = "";
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    @Override
    public String toString() {
        return quantity + " " + product;
    }

    public String getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
