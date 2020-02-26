public class Apple extends Item {
    public Apple() {
        super(Product.APPLE);
        this.unit = "apple";
        this.price = 0.10;

    }

    @Override
    public String toString() {
        if( this.quantity > 1 ) {
            this.unit = "apples";
        }

        return quantity + " " + unit;
    }

}
