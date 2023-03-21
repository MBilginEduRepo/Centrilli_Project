package com.centrilli.pages;

import com.centrilli.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
public class CentrilliHomePage {
    public CentrilliHomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

}
