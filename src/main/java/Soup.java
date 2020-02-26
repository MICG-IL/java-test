public class Soup extends Item {
    public Soup() {
        super("soup");
        this.unit = "tin";
    }
    public void incrementQuantity() {
        this.quantity++;

        if( quantity > 1 ) {
            this.unit = "tins";
        }
    }
}
