import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Item> items = new ArrayList<Item>();

    public void addItem(String product) {
        Item item = new Item(product);
        items.add(item);
    }

    public String getBasketContents() {
        String contents = StringUtils.join(items, ", ");
        return contents;
    }
}
