public class Bread extends Item {
    public Bread() {
        super(Product.BREAD);
        this.unit = "loaf";
        this.price = 0.80;
    }

    @Override
    public String toString() {
        if( this.quantity > 1 ) {
            this.unit = "loaves";
        }
        return super.toString();
    }
}
