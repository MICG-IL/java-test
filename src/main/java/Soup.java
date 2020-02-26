public class Soup extends Item {
    public Soup() {
        super(Product.SOUP);
        this.unit = "tin";
    }
    public void incrementQuantity() {
        this.quantity++;

        if( quantity > 1 ) {
            this.unit = "tins";
        }
    }
}
