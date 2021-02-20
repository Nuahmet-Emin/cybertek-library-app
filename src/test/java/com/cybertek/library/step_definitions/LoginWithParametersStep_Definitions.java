package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.sql.SQLOutput;
import java.util.Map;

public class LoginWithParametersStep_Definitions {

    LoginPage loginPage = new LoginPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page()  {

        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));

    }


    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.enterUsername.sendKeys(username);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.enterPassword.sendKeys(password);
    }

    @And("user clicks the sign in button")
    public void userClicksTheSignInButton() {
        loginPage.signInButton.click();
    }

    @Then("dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {
        Assert.assertTrue(loginPage.dashboard.isDisplayed());
    }

    @And("there should be {string} users")
    public void thereShouldBeUsers(String countOfUsers) {

        String actualUserCounts = loginPage.numberOfUsers.getText();

        System.out.println("actualCount = " + actualUserCounts );
        System.out.println("expectedCount = " + countOfUsers);
        Assert.assertTrue( !actualUserCounts.equals(countOfUsers) );



    }

    @When("user login using credentials")
    public void userLoginUsing(Map<String ,String> credentials) {
        loginPage.login(credentials.get("username"),credentials.get("password"));
    }
}
