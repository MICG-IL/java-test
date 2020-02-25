public class Item {
    private final String product;

    public Item(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return product;
    }
}
