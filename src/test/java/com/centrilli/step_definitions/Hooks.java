package com.centrilli.step_definitions;

import com.centrilli.pages.VehiclesFuelLogs_Page;
import com.centrilli.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {
    //import from io.cucumber.java not from junit

    VehiclesFuelLogs_Page vehiclesFuelLogs_page =new VehiclesFuelLogs_Page();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);
    Faker faker=new Faker();
    @Before
    public void setUpScenario() {
        // System.out.println("====Setting up browser using cucumber @Before");

    }
    @Before ()
    public void setUpScenarioForLogins() {
        //System.out.println("====This will only apply to scenarios with @login tag");

    }
    @Before ()
    public void setUpDatabaseScenario() {
        //System.out.println("====This will only apply to scenarios with @db tag");

    }

    @After
    public void tearDownScenario(Scenario scenario) {

        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png", scenario.getName());

        }



        Driver.closeDriver();

        // System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/Take screenshot if failed!");
    }

    @BeforeStep(value = "@x")
    public void setUpStep()  {
        //wait.until(ExpectedConditions.invisibilityOf(vehiclesFuelLogs_page.loading_Bar));
        //System.out.println("----->applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep()  {
        // System.out.println("----->applying tearDown using @AfterStep");
    }

}
