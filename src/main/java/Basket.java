
import org.javatuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    Map<String, Item> itemsByProduct = new HashMap<String, Item>();

    public void addItem(String product) {
        incrementItemsByProduct(itemsByProduct, product);
    }

    private void incrementItemsByProduct(Map<String, Item> countByItem, String product) {
        Item item = new Item(product);
        countByItem.putIfAbsent(product, item);
        item = countByItem.get(product);
        item.incrementQuantity();
        countByItem.put(product, item);
    }

    public String getBasketContents() {
        StringBuilder contentsOfBasket = new StringBuilder();
        for (String product : itemsByProduct.keySet()) {
            Item item = itemsByProduct.get(product);
            Integer productQuantity = item.getQuantity();
            contentsOfBasket.append(productQuantity + " " + product + ", ");
        }
        contentsOfBasket.delete(contentsOfBasket.length()-2, contentsOfBasket.length());

        return contentsOfBasket.toString();
    }
}
