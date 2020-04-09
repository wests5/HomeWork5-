package com.vytrack.pages;



import com.vytrack.utilities.ConfigurationsReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    protected WebDriver driver = Driver.getDriver();

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public static String title = "Login";

    @FindBy(tagName = "h2")
    public WebElement subTitle;
    @FindBy(css = "label[for='prependedInput']")
    public WebElement userNameLabel;
    @FindBy(id = "prependedInput")
    public WebElement userNameInput;
    @FindBy(css = "label[for='prependedInput2']")
    public WebElement passwordLabel;
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;
    @FindBy(id = "remember_me")
    public WebElement rememberMeCheckBox;
    @FindBy(css = "[class='custom-checkbox__text']")
    public WebElement rememberMeLabel;
    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;
    @FindBy(id = "_submit")
    public WebElement logInBtn;
    @FindBy(className = "login-copyright")
    public WebElement loginCopyRight;
    @FindBy(css= "div[class*='alert']")
    public WebElement invalidCredentialsAlert;

    public void login(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        logInBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

    }
    public void invalidLogin(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        logInBtn.click();


    }

    public void login(String role) {

        switch (role) {
            case "store manager":
                login(ConfigurationsReader.getProperty("store_manager"), ConfigurationsReader.getProperty("password"));
                break;
            case "sales manager":
                login(ConfigurationsReader.getProperty("sales_manager"), ConfigurationsReader.getProperty("password"));
                break;
            case "driver":
                login(ConfigurationsReader.getProperty("truck_driver"), ConfigurationsReader.getProperty("password"));
                break;

        }

    }


}
