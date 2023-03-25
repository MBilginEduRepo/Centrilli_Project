package com.centrilli.step_definitions;

import com.centrilli.pages.VehiclesFuelLogs_Page;
import com.centrilli.pages.Login_Page;
import com.centrilli.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Verifications_StepDefinitions {

    Login_Page login_page = new Login_Page();
    VehiclesFuelLogs_Page vehiclesFuelLogs_page =new VehiclesFuelLogs_Page();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);
    Faker faker=new Faker();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("https://qa.centrilli.com/");
    }
    @When("user types valid credentials")
    public void user_types_valid_credentials() {
        login_page.email.sendKeys("posmanager10@info.com");
        login_page.password.sendKeys("posmanager");
    }
    @Then("user clicks login button")
    public void user_clicks_login_button() {
        login_page.loginButton.click();
    }
    @When("user clicks More Button")
    public void userClicks() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(vehiclesFuelLogs_page.more_Button));
        vehiclesFuelLogs_page.more_Button.click();
    }
    @And("user clicks Fleet Module")
    public void userClicksFleet()  {
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(vehiclesFuelLogs_page.fleet_Module));
        vehiclesFuelLogs_page.fleet_Module.click();
    }
    @And("user clicks Vehicles Fuel Logs Module")
    public void userClicksVehiclesFuelLogsModule()  {
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.vehiclesFuelLogs_Module.click();
    }
    @And("user clicks Create Button")
    public void userClicksCreateButton()  {
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.create_Button.click();
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
    }
    @And("user choose Vehicle")
    public void userChooseVehicle()  {
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.vehicle_Field.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.vehicle_Field.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
    }
    @And("user clicks Save Button")
    public void userClickSaveButton()  {
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.save_Button.click();


    }
    @And("page title changes to the new Vehicle Fuel Logs value")
    public void pageTitleChangesToTheNewVehicleFuelLogsValue() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        String selectedVehicle = vehiclesFuelLogs_page.vehicle_Field.getText();
        Thread.sleep(3000);
        System.out.println("selectedVehicle = " + selectedVehicle);
         Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        String actualTitle = Driver.getDriver().getTitle();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        System.out.println("actualTitle = " + actualTitle);
        Thread.sleep(5000);
        Assert.assertTrue(actualTitle.contains(selectedVehicle));

    }
    @And("user receives a warning popup message, means that he is unable to create a vehicle.")
    public void userReceivesAWarningPopupMessageMeansThatHeIsUnableToCreateAVehicle()  {
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.popUp_Message.isDisplayed();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
    }
    @Then("user makes sure his Fuel Logs is NOT created by verifying page title stayed the same:")
    public void userMakesSureHisFuelLogsIsNOTCreatedByVerifyingPageTitleStayedTheSame()  {
        String expectedTitle="New - Odoo";
        String actualTitle=Driver.getDriver().getTitle();
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        System.out.println("actualTitle = " + actualTitle);

        assertEquals(expectedTitle,actualTitle);

    }
    @And("user clicks to Discard button")
    public void userClicksToDiscardButton()  {
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(vehiclesFuelLogs_page.discard_Button));
        vehiclesFuelLogs_page.discard_Button.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
    }
    @Then("user makes sure his Fuel Logs is discarded by landing on the Vehicles Fuel Logs page")
    public void userMakesSureHisFuelLogsIsDiscardedByLandingOnTheVehiclesFuelLogsPage()  {
        String expectedTitle="Vehicles Fuel Logs - Odoo";
        System.out.println("expectedTitle = " + expectedTitle);
        String actualTitle = Driver.getDriver().getTitle();
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        System.out.println("actualTitle = " + actualTitle);

        assertEquals(expectedTitle,actualTitle);
    }
    @Then("“Attachment” and Action buttons are displayed at the top of the page")
    public void attachmentAndActionButtonsAreDisplayedAtTheTopOfThePage()  {
        vehiclesFuelLogs_page.attachment_Button.isDisplayed();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(vehiclesFuelLogs_page.action_Button));
        vehiclesFuelLogs_page.action_Button.isDisplayed();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
    }
    @And("user sees this warning message {string}")
    public void userSeesThisWarningMessage(String expected)  {
        System.out.println("expected = " + expected);
        String actual=(vehiclesFuelLogs_page.warning_Text.getText());
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        System.out.println("actual = " + actual);

        assertEquals(expected,actual);
    }
    @And("user clicks Ok button")
    public void userClicksOkButton()  {
        vehiclesFuelLogs_page.ok_Button.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
    }
    @Then("user sees the {string} page")
    public void userSeesThePage(String expected)  {
        System.out.println("expected = " + expected);
        String actual= vehiclesFuelLogs_page.moduleVFL_Title.getText();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        System.out.println("actual = " + actual);

        assertEquals(expected,actual);


    }
    @And("user enters vehicle {string}")
    public void userEntersVehicle(String string)  {
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.vehicle_Field.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.vehicle_Field.sendKeys(string);
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.vehicle_Field.sendKeys(Keys.ENTER);
    }
    @And("user enters Odometer Value {double}")
    public void userEntersOdometerValueOdometerValue(Double double1)  {
        vehiclesFuelLogs_page.odometerValue_Field.clear();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.odometerValue_Field.sendKeys(double1+"");
    }
    @When("user enters Liter {double}")
    public void user_enters_liter(Double double1)  {
        vehiclesFuelLogs_page.liter_Field.clear();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.liter_Field.sendKeys(double1+"");
    }
    @When("user enters Price Per Liter {double}")
    public void user_enters_price_per_liter(Double double1)  {
        vehiclesFuelLogs_page.pricePerLiter_Field.clear();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.pricePerLiter_Field.sendKeys(double1+"");
    }
    @When("user enters Total Price {double}")
    public void user_enters_total_price(Double double1)  {
        vehiclesFuelLogs_page.totalPrice_Field.clear();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.totalPrice_Field.click();
    }
    @And("user enters Date {string}")
    public void userEntersDate(String string)  {
        vehiclesFuelLogs_page.date_Field.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.date_Field.sendKeys(string);
    }
    @And("user enters Purchaser {string}")
    public void userEntersPurchaserPurchaser(String string)  {
        vehiclesFuelLogs_page.purchaser_Field.click();
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.purchaser_Field.clear();
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.purchaser_Field.sendKeys(string);
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.purchaser_Field.sendKeys(Keys.ENTER);
    }
    @And("user enters Invoice Reference {string}")
    public void userEntersInvoiceReference(String string)  {
        vehiclesFuelLogs_page.invoiceReference_Field.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.invoiceReference_Field.sendKeys(string);
    }
    @And("user enters Vendor {string}")
    public void userEntersVendor(String string)  {
        vehiclesFuelLogs_page.vendor_Field.click();
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.vendor_Field.clear();
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.vendor_Field.sendKeys(string);
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.vendor_Field.sendKeys(Keys.ENTER);
    }
    @And("user enters Notes {string}")
    public void userEntersNotes(String string)  {
        vehiclesFuelLogs_page.notes_Fieldd.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.notes_Fieldd.sendKeys(string);
    }
    @And("user sees the {string} on the page")
    public void userSeesTheOnThePage(String expected) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        String actual=vehiclesFuelLogs_page.vehicle_Tittle.getText();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        assertEquals(expected, actual);
    }
    @And("user returns to the Vehicle Fuel Logs List by clicking the Vehicles Fuel Logs button")
    public void userReturnsToTheVehicleFuelLogsListByClickingTheVehiclesFuelLogsButton()  {
        vehiclesFuelLogs_page.moduleVFL_Title.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.advanced_Search.click();
    }
    @And("user enters below data in the search box along with filters on the Filters page side.")
    public void userEntersBelowDataInTheSearchBoxAlongWithFiltersOnTheFiltersPageside() {
        vehiclesFuelLogs_page.filters.click();
    }
    @When("user adds vehicle {string}")
    public void user_adds_vehicle(String string)  {
        vehiclesFuelLogs_page.addCustom_Filter.click();
        vehiclesFuelLogs_page.filter_Dropdown1.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Vehicle");
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.sendKeys(string);
        vehiclesFuelLogs_page.apply.click();


    }
    /*@When("user adds Odometer Value {double}")
    public void user_adds_odometer_value(Double double1)  {
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Odometer");
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown2.click();
        new WebDriverWait(Driver.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='o_input']"))).click();
        vehiclesFuelLogs_page.filter_Dropdown2.sendKeys("is equal to");
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.sendKeys(double1+"");
        vehiclesFuelLogs_page.apply.click();

    }

     */
    @When("user adds Liter {double}")
    public void user_adds_liter(Double double1)  {
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Liter");
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.clear();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.sendKeys(double1+"");
        //Thread.sleep(7000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.apply.click();
    }
    @When("user adds Price Per Liter {double}")
    public void user_adds_price_per_liter(Double double1)  {
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Price Per Liter");
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.clear();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.sendKeys(double1+"");
        //Thread.sleep(7000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.apply.click();
    }
    @When("user adds Total Price {double}")
    public void user_adds_total_price(Double double1)  {
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Total Price");
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.clear();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.sendKeys(double1+"");
        vehiclesFuelLogs_page.apply.click();
    }
    @When("user adds Date {string}")
    public void user_adds_date(String string)  {
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Date");
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_DateInput.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_DateInput.sendKeys(string);
        vehiclesFuelLogs_page.apply.click();
    }
    @When("user adds Purchaser {string}")
    public void user_adds_purchaser(String string) throws InterruptedException {
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Purchaser");
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.addCustom_Filter.click();
         Thread.sleep(3000);
        //wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.sendKeys(string);
        vehiclesFuelLogs_page.apply.click();
    }
    @When("user adds Invoice Reference {string}")
    public void user_adds_invoice_reference(String string)  {
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Invoice Reference");
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.sendKeys(string);
        vehiclesFuelLogs_page.apply.click();
    }
    @When("user adds Vendor {string}")
    public void user_adds_vendor(String string)  {
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Vendor");
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.addCustom_Filter.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        new WebDriverWait(Driver.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='o_input']"))).click();
        vehiclesFuelLogs_page.filter_Input.sendKeys(string);
        vehiclesFuelLogs_page.apply.click();
    }
    @When("user adds Notes {string}")
    public void user_adds_notes(String string) throws InterruptedException {
        vehiclesFuelLogs_page.addCustom_Filter.click();
         Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.click();
         Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Notes");
         Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
         Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filters.click();
        vehiclesFuelLogs_page.addCustom_Filter.click();
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        WebElement element = Driver.getDriver().findElement(By.xpath("//input[@class='o_input']"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        vehiclesFuelLogs_page.filter_Input.click();
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.filter_Input.sendKeys(string);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.apply.click();


    }
    @When("user clicks Advanced Search... button")
    public void user_clicks_advanced_search_button() {
        vehiclesFuelLogs_page.advanced_Search.click();
    }
    @Then("user sees the {string} Fuel Logs value.")
    public void userSeesTheFuelLogsValue(String expected) throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.newCreatedVehicle_Line.click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        vehiclesFuelLogs_page.newCreatedVehicle_Name.isDisplayed();
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        String actual=vehiclesFuelLogs_page.newCreatedVehicle_Name.getText();
        Assert.assertEquals(expected,actual);
    }
    @When("users clicks List buttons")
    public void users_clicks_list_buttons()  {
        vehiclesFuelLogs_page.list.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
    }
    @When("user sees changed Fuel Logs display to List")
    public void user_sees_changed_fuel_logs_display_to_list()  {
        String actual=Driver.getDriver().getCurrentUrl();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        String expected="https://qa.centrilli.com/web?#view_type=list&model=fleet.vehicle.log.fuel&menu_id=147&action=164";
        Assert.assertEquals(expected,actual);
    }
    @When("users clicks Kanban buttons")
    public void users_clicks_kanban_buttons()  {
        vehiclesFuelLogs_page.kanban.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
    }
    @When("user sees changed Fuel Logs display to Kanban")
    public void user_sees_changed_fuel_logs_display_to_kanban()  {
        String actual=Driver.getDriver().getCurrentUrl();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        String expected="https://qa.centrilli.com/web?#view_type=kanban&model=fleet.vehicle.log.fuel&menu_id=147&action=164";
        assertEquals(expected,actual);
    }
    @When("users clicks Graph buttons")
    public void users_clicks_graph_buttons()  {
        vehiclesFuelLogs_page.graph.click();
         //Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
    }
    @Then("user sees changed Fuel Logs display to Graph")
    public void user_sees_changed_fuel_logs_display_to_graph() throws InterruptedException {
        String actual=Driver.getDriver().getCurrentUrl();
         Thread.sleep(3000);
        //wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        String expected="https://qa.centrilli.com/web?#view_type=graph&model=fleet.vehicle.log.fuel&menu_id=147&action=164";
        assertEquals(expected,actual);
    }

}
