import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasketTest {
    @Test
    public void firstTest() {
        Basket basket = new Basket();
        assert (basket != null);
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

    @Test
    public void addAnAppleToBasket() {
        Basket basket = new Basket();
        basket.addItem(Product.APPLE);
        String actual = basket.getBasketContents();
        assertThat(actual, containsString("1 apple"));
    }

    @Test
    public void addTwoApplesToBasket() {
        Basket basket = new Basket();
        basket.addItem(Product.APPLE);
        basket.addItem(Product.APPLE);
        String actual = basket.getBasketContents();
        assertThat(actual, containsString("2 apples"));
    }

    @Test
    public void addABottleOfMilkToBasket() {
        Basket basket = new Basket();
        basket.addItem(Product.MILK);
        String actual = basket.getBasketContents();
        assertThat(actual, containsString("1 bottle of milk"));
    }

    @Test
    public void addTwoBottlesOfMilkToBasket() {
        Basket basket = new Basket();
        basket.addItem(Product.MILK);
        basket.addItem(Product.MILK);
        String actual = basket.getBasketContents();
        assertThat(actual, containsString("2 bottles of milk"));
    }


    // Acceptance Test
    @Test
    public void priceBasketWithNoDiscount() {
        Basket basket = new Basket();
        basket.addItem(Product.APPLE, 6);
        basket.addItem(Product.MILK);
        String actual = basket.getTotal();
        assertThat(actual, is("1.90"));
    }

    @Test
    public void priceBasketWithSoupDiscount() {
        Basket basket = new Basket();
        basket.addItem(Product.SOUP, 3);
        basket.addItem(Product.BREAD,2);
        String actual = basket.getTotal();
        assertThat(actual, is("3.15"));
    }

    @Test
    public void priceBasketBeforeSoupDiscountActive() {
        Basket basket = new Basket();
        basket.addItem(Product.SOUP, 3);
        basket.addItem(Product.BREAD,2);
        String actual = basket.getTotal(-2);
        assertThat(actual, is("3.55"));
    }

    @Test
    public void priceBasketFirstDayOfSoupDiscount() {
        Basket basket = new Basket();
        basket.addItem(Product.SOUP, 3);
        basket.addItem(Product.BREAD,2);
        String actual = basket.getTotal(-1);
        assertThat(actual, is("3.15"));
    }

    @Test
    public void priceBasketLastDayOfSoupDiscount() {
        Basket basket = new Basket();
        basket.addItem(Product.SOUP, 3);
        basket.addItem(Product.BREAD,2);
        String actual = basket.getTotal(6);
        assertThat(actual, is("3.15"));
    }

    @Test
    public void priceBasketAfterSoupDiscountExpires() {
        Basket basket = new Basket();
        basket.addItem(Product.SOUP, 3);
        basket.addItem(Product.BREAD,2);
        String actual = basket.getTotal(7);
        assertThat(actual, is("3.55"));
    }

    @Test
    public void priceBasketWithAppleDiscount() {
        Basket basket = new Basket();
        basket.addItem(Product.APPLE, 6);
        basket.addItem(Product.MILK);
        String actual = basket.getTotal(5);
        assertThat(actual, is("1.84"));
    }

    @Test
    public void priceBasketWithAppleAndSoupDiscount() {
        Basket basket = new Basket();
        basket.addItem(Product.APPLE, 3);
        basket.addItem(Product.SOUP, 2);
        basket.addItem(Product.BREAD);
        String actual = basket.getTotal(5);
        assertThat(actual, is("1.97"));
    }

    // todo: Test expired apple discount for 30 day month
    // todo: Test expired apple discount for 31 day month
    // todo: Test expired apple discount for Feb
    // todo: Test expired apple discount for leap year Feb

    // todo: Test apple discount starting 4 days before end of month
    // todo: Test apple discount starting 3 days before end of month
    // todo: Test apple discount starting 2 days before end of month
}