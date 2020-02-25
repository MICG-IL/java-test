import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BasketTest {
    @Test
    public void firstTest() {
        Basket basket = new Basket();
        assert(basket != null);
    }

    @Test
    public void addSoupToBasket() {
        Basket basket = new Basket();
        String actual = basket.addItem("soup");
        assertThat(actual, is("soup"));
    }
}