public class Milk extends Item {
    public Milk() {
        super(Product.MILK);
        this.unit = "bottle";
    }

    public void incrementQuantity() {
        this.quantity++;

        if( quantity > 1 ) {
            this.unit = "bottles";
        }
    }
}
