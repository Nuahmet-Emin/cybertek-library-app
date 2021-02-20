package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UsersPage {
    public UsersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//select[@name='tbl_users_length']")
    public WebElement showRecordsDropdown;
}
