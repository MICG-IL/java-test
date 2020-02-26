
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class Basket {
    Map<Product, Item> itemsByProduct = new HashMap<Product, Item>();
    ProductFactory productFactory = new ProductFactory();

    public void addItem(Product product) {
        Item item = productFactory.getProdcut(product);
        itemsByProduct.putIfAbsent(product, item);
        incrementItemsByProduct(product);
    }

    private void incrementItemsByProduct(Product product) {
        Item item = itemsByProduct.get(product);
        item.incrementQuantity();
        itemsByProduct.put(product, item);
    }

    public String getBasketContents() {
        String contentsOfBasket = itemsByProduct.entrySet()
                .stream()
                .map(item -> ""+item.getValue())
                .collect(joining(", "));
        return contentsOfBasket;
    }
}
