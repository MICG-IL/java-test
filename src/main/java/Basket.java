
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class Basket {
    Map<String, Item> itemsByProduct = new HashMap<String, Item>();

    public void addItem(String product) {
        incrementItemsByProduct(itemsByProduct, product);
    }

    private void incrementItemsByProduct(Map<String, Item> countByItem, String product) {

        Item item;
        if( product == "soup" ) {
            item = new Soup();
        } else {
            item = new Item(product);
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
