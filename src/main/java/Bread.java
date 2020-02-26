public class Bread extends Item {
    public Bread() {
        super("bread");
        this.unit = "loaf";
    }

    public void incrementQuantity() {
        this.quantity++;

        if( quantity > 1 ) {
            this.unit = "loaves";
        }
    }
}
