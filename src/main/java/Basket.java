
import org.javatuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    Map<String, Pair<Item,Integer>> itemsByProduct = new HashMap<String, Pair<Item,Integer>>();

    public void addItem(String product) {
        Item item = new Item(product);
        Pair<Item,Integer> pair = new Pair<>(item,0);
        incrementItemsByProduct(itemsByProduct, pair);
    }

    private void incrementItemsByProduct(Map<String, Pair<Item, Integer>> countByItem, Pair<Item, Integer> pair) {
        String product = pair.getValue0().toString();
        countByItem.putIfAbsent(product, pair);
        Pair<Item, Integer> newPair = countByItem.get(product);
        Integer currentQuantity = newPair.getValue1();
        newPair = newPair.setAt1(currentQuantity + 1);
        countByItem.put(product, newPair);
    }

    public String getBasketContents() {
        StringBuilder contentsOfBasket = new StringBuilder();
        for (String product : itemsByProduct.keySet()) {
            Pair<Item,Integer>productInfo = itemsByProduct.get(product);
            Integer productQuantity = productInfo.getValue1();
            contentsOfBasket.append(productQuantity + " " + product + ", ");
        }
        contentsOfBasket.delete(contentsOfBasket.length()-2, contentsOfBasket.length());

        return contentsOfBasket.toString();
    }
}
