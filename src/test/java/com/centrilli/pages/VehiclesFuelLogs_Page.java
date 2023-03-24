package com.centrilli.pages;

import com.centrilli.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclesFuelLogs_Page {
    public VehiclesFuelLogs_Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="menu_more_container")
    public WebElement more_Button;


    @FindBy(xpath="//a[@data-menu='134']")
    public WebElement fleet_Module;

    @FindBy(xpath= "//a[@data-action-id='164']")
    public WebElement vehiclesFuelLogs_Module;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_list_button_add']")
    public WebElement create_Button;

    @FindBy(xpath = "//*[@id=\"o_field_input_297\"]")
    public WebElement vehicle_Field;

    @FindBy(xpath = "//li[.='Audi/A1/']")
    public WebElement vehicle_Tittle;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement save_Button;

    @FindBy(xpath = "//*[@class=\"o_notification undefined o_error\"]")
    public WebElement popUp_Message;

    @FindBy(xpath = "//*[@accesskey=\"j\"]")
    public WebElement discard_Button;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[2]/button")
    public WebElement attachment_Button;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[3]/button")
    public WebElement action_Button;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]")
    public WebElement warning_Text;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[3]/button[1]")
    public WebElement ok_Button;

    @FindBy(xpath = "//li[.='Vehicles Fuel Logs']")
    public WebElement moduleVFL_Title;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/div[2]/table[1]/tbody/tr[2]/td[2]/div/input")
    public WebElement odometerValue_Field;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/div[1]/table[2]/tbody/tr[2]/td[2]/input")
    public WebElement liter_Field;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/div[1]/table[2]/tbody/tr[3]/td[2]/input")
    public WebElement pricePerLiter_Field;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/div[1]/table[2]/tbody/tr[4]/td[2]/input")
    public WebElement totalPrice_Field;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/div[2]/table[2]/tbody/tr[2]/td[2]/div/input")
    public WebElement date_Field;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/div[2]/table[2]/tbody/tr[3]/td[2]/div/div/input")
    public WebElement purchaser_Field;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/div[2]/table[2]/tbody/tr[4]/td[2]/input")
    public WebElement invoiceReference_Field;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/div[2]/table[2]/tbody/tr[5]/td[2]/div/div/input")
    public WebElement vendor_Field;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div/div/textarea[1]")
    public WebElement notes_Fieldd;

    @FindBy(xpath = "//span[@title='Advanced Search...']")
    public WebElement advanced_Search;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/button")
    public WebElement filters;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[1]/a")
    public WebElement vehicle_addCustom_Filter;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[2]/span[2]/select")
    public WebElement vehicle_filterDropdown1;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[2]/span[3]/input")
    public WebElement vehicle_filterInput;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[5]/button[1]")
    public WebElement vehicle_Apply;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[5]/a")
    public WebElement odometerValue_addCustom_Filter;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[6]/span[2]/select")
    public WebElement odometerValue_filterDropdown1;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[6]/span[3]/input")
    public WebElement odometerValue_filterInput;


    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[7]/button[1]")
    public WebElement odometerValue_Apply;





    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[7]/a")
    public WebElement liter_addCustom_Filter;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[8]/span[2]/select")
    public WebElement liter_filterDropdown1;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[8]/span[3]/input")
    public WebElement liter_filterInput;


    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[9]/button[1]")
    public WebElement liter_Apply;



    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[9]/a")
    public WebElement pricePerLiter_addCustom_Filter;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[10]/span[2]/select")
    public WebElement pricePerLiter_filterDropdown1;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[10]/span[3]/input")
    public WebElement pricePerLiter_filterInput;


    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[13]/button[1]")
    public WebElement pricePerLiter_Apply;





}
