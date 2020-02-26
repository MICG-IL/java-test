public class Milk extends Item {
    public Milk() {
        super(Product.MILK);
        this.unit = "bottle";
        this.price = 1.30;
    }

    @Override
    public String toString() {
        if( this.quantity > 1 ) {
            this.unit = "bottles";
        }
        return super.toString();
    }

}
