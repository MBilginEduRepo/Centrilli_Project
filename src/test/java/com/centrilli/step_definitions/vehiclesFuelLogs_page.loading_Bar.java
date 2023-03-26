package com.centrilli.step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = about:blank
public class vehiclesFuelLogs_page.loading_Bar {

    public vehiclesFuelLogs_page.loading_Bar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}