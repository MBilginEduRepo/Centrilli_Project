package com.centrilli.pages;

import com.centrilli.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CentrilliHomePage {
    public CentrilliHomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="menu_more_container")
    public WebElement MoreButton;


    @FindBy(xpath="//a[@data-menu='134']")
    public WebElement FleetModule;

    @FindBy(xpath= "//a[@data-action-id='164']")
    public WebElement VehiclesFuelLogsModule;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_list_button_add']")
    public WebElement CreateButton;

    @FindBy(xpath = "//*[@id=\"o_field_input_297\"]")
    public WebElement VehicleInputDropDown;


    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement SaveButton;

}
