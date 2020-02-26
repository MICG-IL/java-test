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
        basket.addItem(Product.SOUP);
        String actual = basket.getBasketContents();
        assertThat(actual, containsString("1 tin of soup"));
    }

    @Test
    public void addSoupAndBreadToBasket() {
        Basket basket = new Basket();
        basket.addItem(Product.SOUP);
        basket.addItem(Product.BREAD);
        String actual = basket.getBasketContents();
        assertThat(actual, containsString("1 tin of soup"));
        assertThat(actual, containsString("1 loaf of bread"));
    }

    @Test
    public void addTwoTinsOfSoupToBasket() {
        Basket basket = new Basket();
        basket.addItem(Product.SOUP);
        basket.addItem(Product.SOUP);
        String actual = basket.getBasketContents();
        assertThat(actual, containsString("2 tins of soup"));
    }

    @Test
    public void addTwoLoavesOfBreadToBasket() {
        Basket basket = new Basket();
        basket.addItem(Product.BREAD);
        basket.addItem(Product.BREAD);
        String actual = basket.getBasketContents();
        assertThat(actual, containsString("2 loaves of bread"));
    }
}