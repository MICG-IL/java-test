public class ProductFactory {
    public Item getProduct(Product product) {
        Item item;
        if( product == Product.SOUP ) {
            item = new Soup();
        } else if( product == Product.BREAD ) {
            item = new Bread();
        } else if( product == Product.APPLE ) {
            item = new Apple();
        } else {
            item = new Item(Product.DEFAULT);
        }
        return item;
    }
}
