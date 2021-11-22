package Flink.stepDefinitions;

import Flink.pages.CheckoutPage;
import Flink.pages.DashboardPage;
import Flink.pages.MoisturizersPage;
import Flink.utilities.BrowserUtils;
import Flink.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MoisturizerStepDef {

    @Given("User click to buy moisturizers button")
    public void user_click_to_buy_moisturizers_button() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.moisturizersBuyButton.click();
    }

    @Then("User navigate to {string} page")
    public void user_navigate_to_page(String string) {
        String expectedUrl = "https://weathershopper.pythonanywhere.com/"+string;
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @Given("User add least expensive Aloe moisturizer")
    public void user_add_least_expensive_Aloe_moisturizers() throws InterruptedException {
        MoisturizersPage moisturizersPage = new MoisturizersPage();
        Thread.sleep(2000);
        String[] text = BrowserUtils.getTextElements(moisturizersPage.aloeMoisturizersPrices);
        int[] prices = BrowserUtils.getPrices(text);
        int smallest = BrowserUtils.getSmallest(prices, text.length);
        // to find which price is reflected which product
        List<WebElement> addButtons = moisturizersPage.addButtons;
        String s = Integer.toString(smallest);
        for (int i=0;i<addButtons.size();i++) {
            if(addButtons.get(i).getAttribute("onclick").contains(s)){
                addButtons.get(i).click();
                break;
            }
        }
    }

    @Given("User add least expensive Almond moisturizer")
    public void user_add_least_expensive_Almond_moisturizers() {
        MoisturizersPage moisturizersPage = new MoisturizersPage();
        String[] textElements = BrowserUtils.getTextElements(moisturizersPage.almondMoisturizersPrices);
        int[] prices = BrowserUtils.getPrices(textElements);
        int smallest = BrowserUtils.getSmallest(prices, textElements.length);

        // to find which price is reflected which product
        List<WebElement> addButtons = moisturizersPage.addButtons;
        String s = Integer.toString(smallest);
        for (int i=0;i<addButtons.size();i++) {
            if(addButtons.get(i).getAttribute("onclick").contains(s)){
                addButtons.get(i).click();
                break;
            }
        }
    }

    @Given("User click to Cart button")
    public void user_click_to_Cart_button() {
        MoisturizersPage moisturizersPage = new MoisturizersPage();
        moisturizersPage.cartButton.click();
    }

    @Then("Verify user navigate to checkout page")
    public void verify_user_navigate_to_checkout_page() {
        String expectedUrl = "https://weathershopper.pythonanywhere.com/cart";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        CheckoutPage checkoutPage = new CheckoutPage();
        Assert.assertTrue(checkoutPage.checkout.isDisplayed());
    }
}
