package Flink.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{
    @FindBy(id = "temperature")
    public WebElement temperature;

    @FindBy(xpath = "//a[@href='/moisturizer']/button")
    public WebElement moisturizersBuyButton;

    @FindBy(xpath = "//a[@href='/sunscreen']/button")
    public WebElement sunscreensBuyButton;

}
