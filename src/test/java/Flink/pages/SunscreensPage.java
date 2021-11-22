package Flink.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SunscreensPage extends BasePage{

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public List<WebElement> addButtons;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement payWithCard;

}
