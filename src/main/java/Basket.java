import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    Map<String, Integer> countByProduct = new HashMap<String, Integer>();
    List<Item> items = new ArrayList<Item>();

    public void addItem(String product) {
        Item item = new Item(product);
        items.add(item);

        increment(countByProduct, item.toString());
    }

    private void increment(Map<String, Integer> countByItem, String product) {
        countByItem.putIfAbsent(product, 0);
        countByItem.put(product, countByItem.get(product) + 1);
    }

    public String getBasketContents() {
        StringBuilder mapAsString = new StringBuilder();
        for (String product : countByProduct.keySet()) {
            mapAsString.append(countByProduct.get(product) + " " + product + ", ");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length());

        return mapAsString.toString();
    }
}
