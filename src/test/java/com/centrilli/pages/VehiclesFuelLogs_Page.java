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

    @FindBy(xpath = "//div[@class='o_loading']")
    public WebElement loading_Bar;

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

    @FindBy(xpath = "//button[normalize-space()='Filters']")
    public WebElement filters;

    @FindBy(xpath = "//a[normalize-space()='Add Custom Filter']")
    public WebElement addCustom_Filter;

    @FindBy(xpath = "//select[@class='o_input o_searchview_extended_prop_field']")
    public WebElement filter_Dropdown1;

    @FindBy(xpath = "//select[@class='o_input o_searchview_extended_prop_op']")
    public WebElement filter_Dropdown2;

    @FindBy(xpath = "//input[@class='o_input']")
    public WebElement filter_Input;

    @FindBy(xpath = "//input[@class='o_datepicker_input o_input']")
    public WebElement filter_DateInput;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_apply_filter']")
    public WebElement apply;

    @FindBy(xpath = "//tbody/tr[2]/td[4]")
    public  WebElement newCreatedVehicle_Name;

    @FindBy(xpath = "//th[@class='o_group_name']")
    public WebElement newCreatedVehicle_Line;

    @FindBy(xpath = "//button[@aria-label='list']")
    public WebElement list;

    @FindBy(xpath = "//button[@aria-label='kanban']")
    public WebElement kanban;

    @FindBy(xpath = "//button[@aria-label='graph']")
    public WebElement graph;

    @FindBy(xpath = "//td[@class='o_list_number o_group_pager']//button[@aria-label='Previous']")
    public WebElement leftArrow_Button;

    @FindBy(xpath = "//td[@class='o_list_number o_group_pager']//button[@aria-label='Next']")
    public WebElement rightArrow_Button;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody[1]/tr/td[8]/div/span[1]/span[1]")
    public WebElement page_Counter;











































    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[16]/span[3]/span/div/input")
    public WebElement date_filterInput;


    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[16]/span[3]/span/div/input")
    public WebElement date_Apply;




}
