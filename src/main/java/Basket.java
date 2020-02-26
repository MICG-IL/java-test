import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class Basket {
    Map<Product, Item> itemsByProduct = new HashMap<Product, Item>();
    ProductFactory productFactory = new ProductFactory();

    public void addItem(Product product) {
        addItem(product, 1);
    }
        
    public void addItem(Product product, int quantity) {
        Item item = productFactory.getProduct(product);
        itemsByProduct.putIfAbsent(product, item);
        incrementItemsByProduct(product, quantity);
    }

    private void incrementItemsByProduct(Product product, int quantity) {
        Item item = itemsByProduct.get(product);
        item.incrementQuantity(quantity);
        itemsByProduct.put(product, item);
    }

    public String getBasketContents() {
        String contentsOfBasket = itemsByProduct.entrySet()
                .stream()
                .map(item -> "" + item.getValue())
                .collect(joining(", "));
        return contentsOfBasket;
    }

    public String getTotal() {
        double total = 0;
        for (Map.Entry<Product,Item> entry : itemsByProduct.entrySet())
            total += entry.getValue().getTotal();

        total = applyDiscount(total);

        return formatTotal(total);
    }

    private double applyDiscount(double total) {
        Item soup = itemsByProduct.get(Product.SOUP);
        Item bread = itemsByProduct.get(Product.BREAD);
        if(soup!=null && bread != null) {
            total = applySoupDiscountToBread(total, soup, bread);
        }
        return total;
    }

    private double applySoupDiscountToBread(double total, Item soup, Item bread) {
        // Buy 2 tins of soup and get a loaf of bread half price
        // Effective Dates: yesterday | for 7 days |
        if ((soup.quantity >= 2) && (bread.quantity > 0)) {
            double breadDiscount = (bread.price / 2);
            total = total - breadDiscount;
        }
        return total;
    }

    private String formatTotal(double runningTotal) {
        DecimalFormat formatter = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance( Locale.ENGLISH ));
        formatter.setRoundingMode( RoundingMode.DOWN );
        return formatter.format(runningTotal);
    }
}
