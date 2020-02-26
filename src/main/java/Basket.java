import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static java.util.stream.Collectors.joining;

// todo: Use dates so we can end discounts at the end of a month
// todo: Create small money class to get away from total as double
// todo: Add command line wrappers for UI

public class Basket {
    Map<Product, Item> itemsByProduct = new HashMap<Product, Item>();
    ProductFactory productFactory = new ProductFactory();

    public Basket() {
        for (Product product : Product.values()) {
            Item item = productFactory.getProduct(product);
            itemsByProduct.put(product, item);
        }
    }

    public void addItem(Product product) {
        addItem(product, 1);
    }
        
    public void addItem(Product product, int quantity) {
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
        return getTotal(0);
    }

    public String getTotal(int dayBoughtFromToday) {
        double total = 0;
        for (Map.Entry<Product,Item> entry : itemsByProduct.entrySet())
            total += entry.getValue().getTotal();

        total = applyDiscount(total, dayBoughtFromToday);

        return formatTotal(total);
    }

    private double applyDiscount(double total, int dayBoughtFromToday) {
        total = applySoupDiscountToBread(total, dayBoughtFromToday);
        total = applyAppleDiscount(total, dayBoughtFromToday);
        return total;
    }

    private double applyAppleDiscount(double total, int dayBoughtFromToday) {
        // Apples have a 10% discount
        // from 3 days hence
        // todo: until the end of the following month
        if(dayBoughtFromToday >= 3) {
            Item apple = itemsByProduct.get(Product.APPLE);
            double appleDiscount = apple.getTotal() * 0.1;
            total = total - appleDiscount;
        }
        return total;
    }

    private double applySoupDiscountToBread(double total, int dayBoughtFromToday) {
        // Buy 2 tins of soup and get a loaf of bread half price
        // Effective Dates: yesterday | for 7 days |
        Item soup = itemsByProduct.get(Product.SOUP);
        Item bread = itemsByProduct.get(Product.BREAD);
        if ((soup.quantity >= 2) &&
            (bread.quantity > 0) &&
            (dayBoughtFromToday >= -1) &&
            (dayBoughtFromToday <= 6)) {
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
