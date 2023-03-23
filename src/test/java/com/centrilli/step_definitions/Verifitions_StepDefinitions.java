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
import org.junit.Assert;
import org.openqa.selenium.Keys;
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
        Thread.sleep(1000);
        homePage.MoreButton.click();

    }


    @And("user clicks Fleet Module")
    public void userClicksFleet() throws InterruptedException {
        Thread.sleep(1000);
        homePage.FleetModule.click();
    }

    @And("user clicks Vehicles Fuel Logs Module")
    public void userClicksVehiclesFuelLogsModule() throws InterruptedException {
        Thread.sleep(1000);
        homePage.VehiclesFuelLogsModule.click();
    }

    @And("user clicks Create Button")
    public void userClicksCreateButton() throws InterruptedException {
        Thread.sleep(1000);
        homePage.CreateButton.click();
    }

    @And("user choose Vehicle")
    public void userChooseVehicle() throws InterruptedException {
       homePage.VehicleInputDropDown.click();
        Thread.sleep(1000);
        homePage.VehicleInputDropDown.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    @And("user click Save Button")
    public void userClickSaveButton() throws InterruptedException {
        Thread.sleep(1000);
        homePage.SaveButton.click();
        Thread.sleep(5000);
    }

    @And("page title changes to the new Vehicle Fuel Logs value")
    public void pageTitleChangesToTheNewVehicleFuelLogsValue() throws InterruptedException {
        String selectedVehicle = homePage.VehicleInputDropDown.getText();
        System.out.println("selectedVehicle = " + selectedVehicle);
        Thread.sleep(3000);
        String actualTitle = Driver.getDriver().getTitle();
        Thread.sleep(5000);
        System.out.println("actualTitle = " + actualTitle);

        Assert.assertTrue(actualTitle.contains(selectedVehicle));

    }

    @And("user clicks to Save button")
    public void userClicksToSaveButton() throws InterruptedException {
        Thread.sleep(3000);
        homePage.SaveButton.click();
        Thread.sleep(3000);
    }

    @And("user receives a warning popup message, means that he is unable to create a vehicle.")
    public void userReceivesAWarningPopupMessageMeansThatHeIsUnableToCreateAVehicle() throws InterruptedException {
        homePage.popUpMessage.isDisplayed();
        Thread.sleep(3000);
    }

    @Then("user makes sure his Fuel Logs is NOT created by verifying page title stayed the same:")
    public void userMakesSureHisFuelLogsIsNOTCreatedByVerifyingPageTitleStayedTheSame() throws InterruptedException {
        String expectedTitle="New - Odoo";
        String actualTitle=Driver.getDriver().getTitle();
        Thread.sleep(5000);
        System.out.println("actualTitle = " + actualTitle);

        Assert.assertEquals(expectedTitle,actualTitle);

    }
}
