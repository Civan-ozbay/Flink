package Flink.stepDefinitions;

import Flink.pages.DashboardPage;
import Flink.utilities.ConfigurationReader;
import Flink.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;

public class LoginToShopStepDef {
    String currentTemperature;
    int temperatureAsInt ;
    DashboardPage dashboardPage = new DashboardPage();

    @Given("User enter the weathershopper")
    public void user_enter_the_weathershopper() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("User check the current temperature")
    public void user_check_the_current_temperature() throws InterruptedException {
        currentTemperature = dashboardPage.temperature.getText();
        String[] str = currentTemperature.split(" ");
        temperatureAsInt = Integer.parseInt(str[0]);
    }

    @When("According to temperature user navigate correct page")
    public void according_to_temperature_user_navigate_correct_page() throws InterruptedException {
        String expectedMoisturizers = "https://weathershopper.pythonanywhere.com/moisturizer";
        String expectedSunscreen="https://weathershopper.pythonanywhere.com/sunscreen";
        if (temperatureAsInt<19){
            dashboardPage.moisturizersBuyButton.click();
            String actualMoisturizers = Driver.get().getCurrentUrl();
            Assert.assertEquals(expectedMoisturizers,actualMoisturizers);
            System.out.println("Expected url:"+expectedMoisturizers);
            System.out.println("Actual url:"+actualMoisturizers);
        }else if(temperatureAsInt>34){
            dashboardPage.sunscreensBuyButton.click();
            String actualSunscreen = Driver.get().getCurrentUrl();
            Assert.assertEquals(expectedSunscreen,actualSunscreen);
            System.out.println("Expected url:"+expectedSunscreen);
            System.out.println("Actual url:"+actualSunscreen);
        }else{
            System.out.println("Temperature is between 19 and 34 degrees.");
        }

    }


}
