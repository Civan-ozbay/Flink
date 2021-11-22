package Flink.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
    @FindBy (xpath = "//div[@class='row justify-content-center']/h2")
    public WebElement checkout;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement payWithCard;

    @FindBy(xpath = "//div[@class='title']/h1")
    public WebElement stripeTitle;

    @FindBy(id = "email")
    public WebElement stripeEmail;

    @FindBy(id = "card_number")
    public WebElement stripeCardNumber;

    @FindBy(id = "cc-exp")
    public WebElement stripeExpDate;

    @FindBy(id = "cc-csc")
    public WebElement stripeCVC;

    @FindBy(id = "zip")
    public WebElement stripeZip;

    @FindBy(id = "submitButton")
    public WebElement stripePayButton;

    @FindBy(xpath = "//div[@class='row justify-content-center']")
    public WebElement paymentSuccess;

    @FindBy(xpath = "//p[@class='text-justify']")
    public WebElement paymenSuccessText;
}
