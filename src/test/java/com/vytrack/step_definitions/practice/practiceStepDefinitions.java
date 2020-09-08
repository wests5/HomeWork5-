package com.vytrack.step_definitions.practice;

import com.vytrack.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class practiceStepDefinitions {

    public WebDriver driver = Driver.getDriver();
    @Test
    public void t1() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 10);

        Select select = new Select(Driver.getDriver().findElement(By.id("sdg")));


    }
}
