package com.vytrack.pages;



import com.vytrack.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {




    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "body>div[class='loader-mask']")
    public WebElement loaderMask;
    @FindBy(css = ".oro-subtitle")
    public WebElement subtitle;

    public void navigateTo(String module, String subModule){
        WebElement m1 = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-1' and normalize-space()='"+module+"']"));
        WebElement m2 = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-2' and normalize-space()='"+subModule+"']"));

        wait.until(ExpectedConditions.visibilityOf(m1));
        wait.until(ExpectedConditions.elementToBeClickable(m1));
        m1.click();
        wait.until(ExpectedConditions.visibilityOf(m2));
        wait.until(ExpectedConditions.elementToBeClickable(m2));
        m2.click();
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }
    public void waitUntilLoaderMaskDisapear(){
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }

    public void verifySubtitle(String expected){
        Assert.assertEquals(expected, subtitle.getText());
    }


}
