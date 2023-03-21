package com.centrilli.step_definitions;

import com.centrilli.pages.CentrilliHomePage;
import com.centrilli.pages.CentrilliLoginPage;
import com.centrilli.utilities.ConfigurationReader;
import com.centrilli.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class Verifitions_StepDefinitions {

    CentrilliLoginPage loginPage= new CentrilliLoginPage();

    CentrilliHomePage homePage=new CentrilliHomePage();

    Faker faker=new Faker();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("https://qa.centrilli.com/");
    }
    @When("user types valid credentials")
    public void user_types_valid_credentials() {
        loginPage.email.sendKeys("posmanager10@info.com");
        loginPage.password.sendKeys("posmanager");
    }
    @Then("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }


    @When("user clicks More Button")
    public void userClicks() throws InterruptedException {
        Thread.sleep(5000);
        homePage.MoreButton.click();

    }


    @And("user clicks Fleet Module")
    public void userClicksFleet() throws InterruptedException {
        Thread.sleep(5000);
        homePage.FleetModule.click();
    }

    @And("user clicks Vehicles Fuel Logs Module")
    public void userClicksVehiclesFuelLogsModule() throws InterruptedException {
        Thread.sleep(5000);
        homePage.VehiclesFuelLogsModule.click();
    }

    @And("user clicks Create Button")
    public void userClicksCreateButton() throws InterruptedException {
        Thread.sleep(5000);
        homePage.CreateButton.click();
    }

    @And("user choose Vehicle")
    public void userChooseVehicle() throws InterruptedException {
        Thread.sleep(5000);
        homePage.VehicleInputDropDown.click();

    }
}
