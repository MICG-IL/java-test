public class Apple extends Item {
    public Apple() {
        super(Product.APPLE);
        this.unit = "apple";
    }

    @Override
    public String toString() {
        return quantity + " " + unit;
    }

}
