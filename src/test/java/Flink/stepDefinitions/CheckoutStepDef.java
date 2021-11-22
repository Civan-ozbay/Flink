package Flink.stepDefinitions;

import Flink.pages.CheckoutPage;
import Flink.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Map;

public class CheckoutStepDef {
    @Given("User click to pay with card button")
    public void user_click_to_pay_with_card_button() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage();
        Thread.sleep(3000);
        checkoutPage.payWithCard.click();
    }
    @Given("Verify shopping cart looks correct")
    public void verify_shopping_cart_looks_correct() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage();
        //WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        //wait.until(ExpectedConditions.visibilityOf(checkoutPage.stripeEmail));
        Driver.get().switchTo().frame("stripe_checkout_app");
        Thread.sleep(2000);
        Assert.assertTrue(checkoutPage.stripeEmail.isDisplayed());
        Assert.assertTrue(checkoutPage.stripeCardNumber.isDisplayed());
        Assert.assertTrue(checkoutPage.stripeExpDate.isDisplayed());
        Assert.assertTrue(checkoutPage.stripeCVC.isDisplayed());

    }
    @Given("User pays using the following credentials")
    public void user_pays_using_the_following_credentials(Map<String,String> userInfo) throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.stripeEmail.sendKeys(userInfo.get("email"));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        Thread.sleep(3000);
        jse.executeScript("document.getElementById('card_number').value='"+userInfo.get("card number")+"';");
        jse.executeScript("document.getElementById('cc-csc').value='"+userInfo.get("CVC")+"';");
        checkoutPage.stripeExpDate.click();
        Thread.sleep(2000);
        checkoutPage.stripeExpDate.sendKeys(userInfo.get("expiration date month"));
        checkoutPage.stripeExpDate.sendKeys(userInfo.get("expiration date year"));
        jse.executeScript("document.getElementById('billing-zip').value='"+userInfo.get("Zip Code")+"';");

    }
    @Then("User click to pay button")
    public void user_click_to_pay_button() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.stripePayButton.click();


    }
    @Then("Verify payment success message is displayed")
    public void verify_payment_success_message_is_displayed() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage();
        Thread.sleep(4000);
        String actualText = checkoutPage.paymenSuccessText.getText();
        String expectedText = "Your payment was successful. You should receive a follow-up call from our sales team.";
        Assert.assertEquals(expectedText,actualText);
        String expectedUrl = "https://weathershopper.pythonanywhere.com/confirmation";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

}
