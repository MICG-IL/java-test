public class Apple extends Item {
    public Apple() {
        super(Product.APPLE);
        this.unit = "apple";
    }

    public void incrementQuantity() {
        this.quantity++;

        if( quantity > 1 ) {
            this.unit = "apples";
        }
    }

    @Override
    public String toString() {
        return quantity + " " + unit;
    }

}
