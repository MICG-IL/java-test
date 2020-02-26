
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class Basket {
    Map<Product, Item> itemsByProduct = new HashMap<Product, Item>();

    public void addItem(Product product) {
        incrementItemsByProduct(itemsByProduct, product);
    }

    private void incrementItemsByProduct(Map<Product, Item> countByItem, Product product) {

        Item item;
        if( product == Product.SOUP ) {
            item = new Soup();
        } else if( product == Product.BREAD ) {
            item = new Bread();
        } else {
            item = new Item(Product.DEFAULT);
        }
        countByItem.putIfAbsent(product, item);
        item = countByItem.get(product);
        item.incrementQuantity();
        countByItem.put(product, item);
    }

    public String getBasketContents() {
        String contentsOfBasket = itemsByProduct.entrySet()
                .stream()
                .map(item -> ""+item.getValue())
                .collect(joining(", "));
        return contentsOfBasket;
    }
}
