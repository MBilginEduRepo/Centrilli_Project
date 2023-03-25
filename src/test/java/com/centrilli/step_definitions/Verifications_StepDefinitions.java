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
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Verifications_StepDefinitions {

    Login_Page login_page = new Login_Page();

    VehiclesFuelLogs_Page vehiclesFuelLogs_page =new VehiclesFuelLogs_Page();

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
        Thread.sleep(3000);
        vehiclesFuelLogs_page.more_Button.click();

    }


    @And("user clicks Fleet Module")
    public void userClicksFleet() throws InterruptedException {
        Thread.sleep(3000);
        vehiclesFuelLogs_page.fleet_Module.click();
    }

    @And("user clicks Vehicles Fuel Logs Module")
    public void userClicksVehiclesFuelLogsModule() throws InterruptedException {
        Thread.sleep(3000);
        vehiclesFuelLogs_page.vehiclesFuelLogs_Module.click();
    }

    @And("user clicks Create Button")
    public void userClicksCreateButton() throws InterruptedException {
        Thread.sleep(3000);
        vehiclesFuelLogs_page.create_Button.click();
    }

    @And("user choose Vehicle")
    public void userChooseVehicle() throws InterruptedException {
       vehiclesFuelLogs_page.vehicle_Field.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.vehicle_Field.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @And("user click Save Button")
    public void userClickSaveButton() throws InterruptedException {
        Thread.sleep(3000);
        vehiclesFuelLogs_page.save_Button.click();
        Thread.sleep(5000);
    }

    @And("page title changes to the new Vehicle Fuel Logs value")
    public void pageTitleChangesToTheNewVehicleFuelLogsValue() throws InterruptedException {
        String selectedVehicle = vehiclesFuelLogs_page.vehicle_Field.getText();
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
        vehiclesFuelLogs_page.save_Button.click();
        Thread.sleep(3000);
    }

    @And("user receives a warning popup message, means that he is unable to create a vehicle.")
    public void userReceivesAWarningPopupMessageMeansThatHeIsUnableToCreateAVehicle() throws InterruptedException {
        vehiclesFuelLogs_page.popUp_Message.isDisplayed();
        Thread.sleep(3000);
    }

    @Then("user makes sure his Fuel Logs is NOT created by verifying page title stayed the same:")
    public void userMakesSureHisFuelLogsIsNOTCreatedByVerifyingPageTitleStayedTheSame() throws InterruptedException {
        String expectedTitle="New - Odoo";
        String actualTitle=Driver.getDriver().getTitle();
        Thread.sleep(5000);
        System.out.println("actualTitle = " + actualTitle);

        assertEquals(expectedTitle,actualTitle);

    }

    @And("user clicks to Discard button")
    public void userClicksToDiscardButton() throws InterruptedException {
        Thread.sleep(3000);
        vehiclesFuelLogs_page.discard_Button.click();
        Thread.sleep(3000);
    }

    @Then("user makes sure his Fuel Logs is discarded by landing on the Vehicles Fuel Logs page")
    public void userMakesSureHisFuelLogsIsDiscardedByLandingOnTheVehiclesFuelLogsPage() throws InterruptedException {
        String expectedTitle="Vehicles Fuel Logs - Odoo";
        System.out.println("expectedTitle = " + expectedTitle);
        String actualTitle = Driver.getDriver().getTitle();
        Thread.sleep(5000);
        System.out.println("actualTitle = " + actualTitle);
        assertEquals(expectedTitle,actualTitle);
    }

    @Then("“Attachment” and Action buttons are displayed at the top of the page")
    public void attachmentAndActionButtonsAreDisplayedAtTheTopOfThePage() throws InterruptedException {
        vehiclesFuelLogs_page.attachment_Button.isDisplayed();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.action_Button.isDisplayed();
        Thread.sleep(3000);
    }

    @And("user sees this warning message {string}")
    public void userSeesThisWarningMessage(String expected) throws InterruptedException {
        System.out.println("expected = " + expected);
        String actual=(vehiclesFuelLogs_page.warning_Text.getText());
        Thread.sleep(3000);
        System.out.println("actual = " + actual);

        assertEquals(expected,actual);
    }

    @And("user clicks Ok button")
    public void userClicksOkButton() throws InterruptedException {
        vehiclesFuelLogs_page.ok_Button.click();
        Thread.sleep(3000);
    }

    @Then("user sees the {string} page")
    public void userSeesThePage(String expected) throws InterruptedException {
        System.out.println("expected = " + expected);
        String actual= vehiclesFuelLogs_page.moduleVFL_Title.getText();
        Thread.sleep(3000);
        System.out.println("actual = " + actual);

        assertEquals(expected,actual);


    }

    @And("user enters vehicle {string}")
    public void userEntersVehicle(String string) throws InterruptedException {
        vehiclesFuelLogs_page.vehicle_Field.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.vehicle_Field.sendKeys(string);
        Thread.sleep(3000);
        vehiclesFuelLogs_page.vehicle_Field.sendKeys(Keys.ENTER);
    }


   @And("user enters Odometer Value {double}")
    public void userEntersOdometerValueOdometerValue(Double double1) throws InterruptedException {
        vehiclesFuelLogs_page.odometerValue_Field.clear();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.odometerValue_Field.sendKeys(double1+"");
    }


    @When("user enters Liter {double}")
    public void user_enters_liter(Double double1) throws InterruptedException {
        vehiclesFuelLogs_page.liter_Field.clear();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.liter_Field.sendKeys(double1+"");
    }

    @When("user enters Price Per Liter {double}")
    public void user_enters_price_per_liter(Double double1) throws InterruptedException {
        vehiclesFuelLogs_page.pricePerLiter_Field.clear();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.pricePerLiter_Field.sendKeys(double1+"");
    }

    @When("user enters Total Price {double}")
    public void user_enters_total_price(Double double1) throws InterruptedException {
        vehiclesFuelLogs_page.totalPrice_Field.clear();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.totalPrice_Field.click();
    }

    @And("user enters Date {string}")
    public void userEntersDate(String string) throws InterruptedException {
        vehiclesFuelLogs_page.date_Field.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.date_Field.sendKeys(string);
    }

    @And("user enters Purchaser {string}")
    public void userEntersPurchaserPurchaser(String string) throws InterruptedException {
        vehiclesFuelLogs_page.purchaser_Field.click();
        Thread.sleep(1000);
        vehiclesFuelLogs_page.purchaser_Field.clear();
        Thread.sleep(1000);
        vehiclesFuelLogs_page.purchaser_Field.sendKeys(string);
        Thread.sleep(1000);
        vehiclesFuelLogs_page.purchaser_Field.sendKeys(Keys.ENTER);
    }

    @And("user enters Invoice Reference {string}")
    public void userEntersInvoiceReference(String string) throws InterruptedException {
        vehiclesFuelLogs_page.invoiceReference_Field.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.invoiceReference_Field.sendKeys(string);
    }

    @And("user enters Vendor {string}")
    public void userEntersVendor(String string) throws InterruptedException {
        vehiclesFuelLogs_page.vendor_Field.click();
        Thread.sleep(1000);
        vehiclesFuelLogs_page.vendor_Field.clear();
        Thread.sleep(1000);
        vehiclesFuelLogs_page.vendor_Field.sendKeys(string);
        Thread.sleep(1000);
        vehiclesFuelLogs_page.vendor_Field.sendKeys(Keys.ENTER);
    }

    @And("user enters Notes {string}")
    public void userEntersNotes(String string) throws InterruptedException {
        vehiclesFuelLogs_page.notes_Fieldd.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.notes_Fieldd.sendKeys(string);
    }

    @And("user sees the {string} on the page")
    public void userSeesTheOnThePage(String expected) throws InterruptedException {
       String actual=vehiclesFuelLogs_page.vehicle_Tittle.getText();
       Thread.sleep(3000);
        assertEquals(expected, actual);
    }

    @And("user returns to the Vehicle Fuel Logs List by clicking the Vehicles Fuel Logs button")
    public void userReturnsToTheVehicleFuelLogsListByClickingTheVehiclesFuelLogsButton() throws InterruptedException {
        vehiclesFuelLogs_page.moduleVFL_Title.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.advanced_Search.click();
    }

    @And("user enters below data in the search box along with filters on the Filters page side.")
    public void userEntersBelowDataInTheSearchBoxAlongWithFiltersOnTheFiltersPageside() {
        vehiclesFuelLogs_page.filters.click();
    }

    @When("user adds vehicle {string}")
    public void user_adds_vehicle(String string) throws InterruptedException {
        vehiclesFuelLogs_page.addCustom_Filter.click();
        vehiclesFuelLogs_page.filter_Dropdown1.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Vehicle");
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.sendKeys(string);
        vehiclesFuelLogs_page.apply.click();


    }

    /*@When("user adds Odometer Value {double}")
    public void user_adds_odometer_value(Double double1) throws InterruptedException {
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Odometer");
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown2.click();
        new WebDriverWait(Driver.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='o_input']"))).click();
        vehiclesFuelLogs_page.filter_Dropdown2.sendKeys("is equal to");
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.sendKeys(double1+"");
        vehiclesFuelLogs_page.apply.click();

    }

     */

    @When("user adds Liter {double}")
    public void user_adds_liter(Double double1) throws InterruptedException {
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Liter");
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.clear();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.sendKeys(double1+"");
        Thread.sleep(7000);
        vehiclesFuelLogs_page.apply.click();
    }

    @When("user adds Price Per Liter {double}")
    public void user_adds_price_per_liter(Double double1) throws InterruptedException {
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Price Per Liter");
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.clear();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.sendKeys(double1+"");
        Thread.sleep(7000);
        vehiclesFuelLogs_page.apply.click();
    }

    @When("user adds Total Price {double}")
    public void user_adds_total_price(Double double1) throws InterruptedException {
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Total Price");
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.clear();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.sendKeys(double1+"");
        vehiclesFuelLogs_page.apply.click();
    }

    @When("user adds Date {string}")
    public void user_adds_date(String string) throws InterruptedException {
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Date");
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_DateInput.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_DateInput.sendKeys(string);
        vehiclesFuelLogs_page.apply.click();
    }

    @When("user adds Purchaser {string}")
    public void user_adds_purchaser(String string) throws InterruptedException {
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Purchaser");
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.sendKeys(string);
        vehiclesFuelLogs_page.apply.click();
    }

    @When("user adds Invoice Reference {string}")
    public void user_adds_invoice_reference(String string) throws InterruptedException {
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Invoice Reference");
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.sendKeys(string);
        vehiclesFuelLogs_page.apply.click();
    }

    @When("user adds Vendor {string}")
    public void user_adds_vendor(String string) throws InterruptedException {
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Vendor");
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.click();
        Thread.sleep(3000);
        new WebDriverWait(Driver.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='o_input']"))).click();
        vehiclesFuelLogs_page.filter_Input.sendKeys(string);
        vehiclesFuelLogs_page.apply.click();
    }

    @When("user adds Notes {string}")
    public void user_adds_notes(String string) throws InterruptedException {
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Dropdown1.sendKeys("Notes");
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filters.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.addCustom_Filter.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.click();
        Thread.sleep(3000);
        vehiclesFuelLogs_page.filter_Input.sendKeys(string);
        vehiclesFuelLogs_page.apply.click();

    }

    @When("user clicks Advanced Search... button")
    public void user_clicks_advanced_search_button() {
        vehiclesFuelLogs_page.advanced_Search.click();
    }


    @Then("user sees the {string} Fuel Logs value.")
    public void userSeesTheFuelLogsValue(String string) {
        vehiclesFuelLogs_page.newCreatedVehicle_Name.isDisplayed();
        String actual=vehiclesFuelLogs_page.newCreatedVehicle_Name.getText();
        assertEquals(string,actual);
    }

    @When("users clicks List buttons")
    public void users_clicks_list_buttons() throws InterruptedException {
        vehiclesFuelLogs_page.list.click();
        Thread.sleep(3000);
    }

    @When("user sees changed Fuel Logs display to List")
    public void user_sees_changed_fuel_logs_display_to_list() throws InterruptedException {
        String actual=Driver.getDriver().getCurrentUrl();
        Thread.sleep(3000);
        String expected="https://qa.centrilli.com/web?#view_type=list&model=fleet.vehicle.log.fuel&menu_id=147&action=164";
        Assert.assertEquals(expected,actual);
    }
    @When("users clicks Kanban buttons")
    public void users_clicks_kanban_buttons() throws InterruptedException {
        vehiclesFuelLogs_page.kanban.click();
        Thread.sleep(3000);
    }
    @When("user sees changed Fuel Logs display to Kanban")
    public void user_sees_changed_fuel_logs_display_to_kanban() throws InterruptedException {
        String actual=Driver.getDriver().getCurrentUrl();
        Thread.sleep(3000);
        String expected="https://qa.centrilli.com/web?#view_type=kanban&model=fleet.vehicle.log.fuel&menu_id=147&action=164";
        assertEquals(expected,actual);
    }
    @When("users clicks Graph buttons")
    public void users_clicks_graph_buttons() throws InterruptedException {
        vehiclesFuelLogs_page.graph.click();
        Thread.sleep(3000);
    }
    @Then("user sees changed Fuel Logs display to Graph")
    public void user_sees_changed_fuel_logs_display_to_graph() throws InterruptedException {
        String actual=Driver.getDriver().getCurrentUrl();
        Thread.sleep(3000);
        String expected="https://qa.centrilli.com/web?#view_type=graph&model=fleet.vehicle.log.fuel&menu_id=147&action=164";
        assertEquals(expected,actual);
    }

}
