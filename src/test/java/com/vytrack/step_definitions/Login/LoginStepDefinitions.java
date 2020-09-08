package com.vytrack.step_definitions.Login;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationsReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationsReader.getProperty("url"));


    }

    @Given("user logs in as a {string}")
    public void user_logs_in_as_a(String role) {
        loginPage.login(role);
    }

    @Given("user verify {string} subtitle is displayed")
    public void user_verify_is_displayed(String subTitle) {
        loginPage.verifySubtitle(subTitle);
    }
    @Given("user logs in with invalid credentials {string} and {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        loginPage.invalidLogin(username, password);
    }

    @Then("use verify {string} messege is displayed")
    public void use_verify_messege_is_displayed(String str) {
        Assert.assertEquals(str, loginPage.invalidCredentialsAlert.getText());

    }

}
