package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
    private static WebDriver driver;
   // private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    /**
     * private default constructor to prevent creating object of Driver class.
     * Singleton pattern
     */
    private Driver(){}

    /**
     * Method returns webdriver object depends on browser name. Create new object only
     * if driver == null, otherwise returns existing
     * @return
     */
    public static WebDriver getDriver(){
        String browserName = ConfigurationsReader.getProperty("browser");
        if(driver==null){
            if(browserName.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }else if(browserName.equals("headless chrome")){
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                driver = new ChromeDriver(options);

            } else if(browserName.equals("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }else if(browserName.equals("IE")){
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }
        }
        return driver;
    }

    /**
     * Method close driver object and assign null to it to prevent using closed
     * object further
     */
    public static void close(){
        if(driver!=null){
            driver.quit();
            driver=null;

        }
    }





}
