package com.centrilli.step_definitions;

import com.centrilli.pages.CentrilliHomePage;
import com.centrilli.pages.CentrilliLoginPage;
import com.centrilli.utilities.ConfigurationReader;
import com.centrilli.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
    @When("user clicks a more dropdown toggle in the main menu bar")
    public void user_clicks_a_more_dropdown_toggle_in_the_main_menu_bar() {
        System.out.println("hello");
    }


}
