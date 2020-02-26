public class Bread extends Item {
    public Bread() {
        super(Product.BREAD);
        this.unit = "loaf";
    }

    public void incrementQuantity() {
        this.quantity++;

        if( quantity > 1 ) {
            this.unit = "loaves";
        }
    }
}
