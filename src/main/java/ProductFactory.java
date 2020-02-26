public class ProductFactory {
    public Item getProdcut(Product product) {
        Item item;
        if( product == Product.SOUP ) {
            item = new Soup();
        } else if( product == Product.BREAD ) {
            item = new Bread();
        } else {
            item = new Item(Product.DEFAULT);
        }
        return item;
    }
}
