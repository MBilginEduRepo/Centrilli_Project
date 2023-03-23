package com.centrilli.pages;

import com.centrilli.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

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

    @FindBy(xpath = "//*[@class=\"o_notification undefined o_error\"]")
    public WebElement popUpMessage;

    @FindBy(xpath = "//*[@accesskey=\"j\"]")
    public WebElement discardButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[2]/button")
    public WebElement attachmentButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[3]/button")
    public WebElement actionButton;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]")
    public WebElement warningText;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[3]/button[1]")
    public WebElement okButton;

    @FindBy(xpath = "//li[.='Vehicles Fuel Logs']")
    public WebElement moduleVflTitle;

}
