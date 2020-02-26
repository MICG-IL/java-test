public class Soup extends Item {
    public Soup() {
        super(Product.SOUP);
        this.unit = "tin";
        this.price = 0.65;
    }

    @Override
    public String toString() {
        if( this.quantity > 1 ) {
            this.unit = "tins";
        }
        return super.toString();
    }
}
