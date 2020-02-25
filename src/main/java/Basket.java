import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<String> items = new ArrayList<String>();

    public void addItem(String product) {
        items.add(product);
    }

    public String getBasketContents() {
        String contents = String.join(", ", items);
        return contents;
    }
}
