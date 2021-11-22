package Flink.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MoisturizersPage extends BasePage{

    @FindBy(xpath = "//div[@class='text-center col-4']/p/following-sibling::p")
    public List<WebElement> allMoisturizersPrices;

    @FindBy(xpath = "//div[@class='text-center col-4']/p[1]")
    public List<WebElement> allMoisturizersName;

    @FindBy(xpath = "//div[@class='text-center col-4']")
    public List<WebElement> allMoisturizers;

    @FindBy(xpath = "//p[contains(text(),'Aloe')]/following-sibling::p")
    public List<WebElement> aloeMoisturizersPrices;

    @FindBy(xpath = "//p[contains(text(),'lmond')]/following-sibling::p")
    public List<WebElement> almondMoisturizersPrices;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public List<WebElement> addButtons;

    @FindBy(id = "cart")
    public WebElement cartButton;
}
