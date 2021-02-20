package com.cybertek.library.pages;

import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement enterUsername;

    @FindBy(id = "inputPassword")
    public WebElement enterPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashboard;

    public void login(String username, String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
        enterUsername.sendKeys(username);
        enterPassword.sendKeys(password + Keys.ENTER);

    }

    @FindBy(id = "user_count")
    public WebElement numberOfUsers;





}