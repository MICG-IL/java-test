import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
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
        basket.addItem("soup");
        String actual = basket.getBasketContents();
        assertThat(actual, containsString("1 tin of soup"));
    }

    @Test
    public void addSoupAndBreadToBasket() {
        Basket basket = new Basket();
        basket.addItem("soup");
        basket.addItem("bread");
        String actual = basket.getBasketContents();
        assertThat(actual, containsString("1 tin of soup"));
        assertThat(actual, containsString("1 loaf of bread"));
    }

    @Test
    public void addTwoTinsOfSoupToBasket() {
        Basket basket = new Basket();
        basket.addItem("soup");
        basket.addItem("soup");
        String actual = basket.getBasketContents();
        assertThat(actual, containsString("2 tins of soup"));
    }
}