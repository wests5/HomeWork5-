package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;

public class Hook {

    @Before
    public void setUp(){
        Driver.getDriver().manage().window().maximize();


    }
    @After()
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }


        Driver.close();


    }



}
