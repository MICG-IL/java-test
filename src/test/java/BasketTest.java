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
        basket.addItem("soup");
        String actual = basket.getBasketContents();
        assertThat(actual, is("1 soup"));
    }

    @Test
    public void addSoupAndBreadToBasket() {
        Basket basket = new Basket();
        basket.addItem("soup");
        basket.addItem("bread");
        String actual = basket.getBasketContents();
        assertThat(actual, is("1 soup, 1 bread"));
    }

    @Test
    public void addTwoTinsOfSoupToBasket() {
        Basket basket = new Basket();
        basket.addItem("soup");
        basket.addItem("soup");
        String actual = basket.getBasketContents();
        assertThat(actual, is("2 soup"));
    }
}