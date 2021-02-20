package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    @When("user enters librarian username")
    public void user_enters_librarian_username()  {

        String username = ConfigurationReader.getProperty("lib_username");
        loginPage.enterUsername.sendKeys(username);

    }



    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        String password =ConfigurationReader.getProperty("lib_password");
        loginPage.enterPassword.sendKeys(password + Keys.ENTER);
    }
    @Then("user should see dashboard")
    public void user_should_see_dashboard() {
      String expectedInTitle= "Library";
      String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }
}
