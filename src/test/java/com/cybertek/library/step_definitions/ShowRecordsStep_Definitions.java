package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ShowRecordsStep_Definitions {
    LoginPage loginPage = new LoginPage();
    LandingPage landingPage = new LandingPage();
    UsersPage usersPage = new UsersPage();
    Select select;


    @Given("user is logged in")
    public void user_is_logged_in() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
        String username = ConfigurationReader.getProperty("lib_username");
        String password = ConfigurationReader.getProperty("lib_password");

        loginPage.login(username, password);
    }

    @When("user clicks on Users link")
    public void user_clicks_on_users_link() {
        landingPage.usersModule.click();
    }

    @Then("show records dropdown value should be {int} by default")
    public void show_records_dropdown_value_should_be_by_default(Integer int1) {
        select = new Select(usersPage.showRecordsDropdown);


        String actualDropdownValue = select.getFirstSelectedOption().getText();
        System.out.println(actualDropdownValue);

        Assert.assertTrue(Integer.parseInt(actualDropdownValue) == int1); // int1 + "" works too


    }

    @Then("show records should have following options:")
    public void and_show_records_should_have_following_options(List<String> options) {
        /*System.out.println("options.size() = " + options.size());
        System.out.println("options = " + options);*/

        List<String> actualTexts = new ArrayList<>();
        for (WebElement eachElement : select.getOptions()) {
            actualTexts.add(eachElement.getText());
        }
        Assert.assertEquals(options, actualTexts);
    }


}
