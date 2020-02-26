public class Item {
    private final String product;
    private int quantity;

    public Item(String product) {
        this.product = product;
        this.quantity = 0;
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
