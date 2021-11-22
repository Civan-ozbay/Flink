package Flink.stepDefinitions;

import Flink.pages.DashboardPage;
import Flink.pages.SunscreensPage;
import Flink.utilities.BrowserUtils;
import Flink.utilities.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SunscreensStepDef {
    @Given("User click to buy sunscreens button")
    public void user_click_to_buy_sunscreens_button() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.sunscreensBuyButton.click();
    }

    @Given("User add least expensive {string} sunscreen")
    public void user_add_least_expensive_sunscreen(String string) {
        SunscreensPage sunscreensPage = new SunscreensPage();
        String[] textElements = BrowserUtils.getTextElements(Driver.get().findElements(By.xpath("//p[contains(text(),'"+string+"')]/following-sibling::p")));
        int[] prices = BrowserUtils.getPrices(textElements);
        int smallest = BrowserUtils.getSmallest(prices, textElements.length);
        List<WebElement> addButtons = sunscreensPage.addButtons;
        String s = Integer.toString(smallest);
        for (int i=0;i<addButtons.size();i++) {
            if(addButtons.get(i).getAttribute("onclick").contains(s)){
                addButtons.get(i).click();
                break;
            }
        }
    }

    @Given("Secondly User add least expensive {string} sunscreen")
    public void secondly_User_add_least_expensive_sunscreen(String string) {
        SunscreensPage sunscreensPage = new SunscreensPage();
        String[] textElements = BrowserUtils.getTextElements(Driver.get().findElements(By.xpath("//p[contains(text(),'"+string+"')]/following-sibling::p")));
        int[] prices = BrowserUtils.getPrices(textElements);
        int smallest = BrowserUtils.getSmallest(prices, textElements.length);
        List<WebElement> addButtons = sunscreensPage.addButtons;
        String s = Integer.toString(smallest);
        for (int i=0;i<addButtons.size();i++) {
            if(addButtons.get(i).getAttribute("onclick").contains(s)){
                addButtons.get(i).click();
                break;
            }
        }
    }




}
