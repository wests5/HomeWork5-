package com.vytrack.step_definitions.Activities;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarEventsStepDefinitions {
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Given("user navigate to {string} and then to {string}")
    public void user_navigate_to_and_then_to(String module, String subModule) {
        calendarEventsPage.navigateTo(module, subModule);
    }

    @Then("user hover over three dots for random event")
    public void user_hover_over_three_dots_for_random_event() {

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(calendarEventsPage.threeDotsTbody.get(new Random().nextInt(calendarEventsPage.threeDotsTbody.size()))).build().perform();


    }

    @Then("user verify that view, edit and delete options are available")
    public void user_verify_that_view_edit_and_delete_options_are_available() {
        List<WebElement> l1 = Driver.getDriver().findElements(By.xpath("//div[@id='bottom-anchor']/following-sibling::ul//a"));
        for (WebElement each : l1) {
            Assert.assertTrue(each.isDisplayed());
        }

    }

    @Given("user click on Grid Options button")
    public void user_click_on_Grid_Options_button() {
        calendarEventsPage.gridSettingsBtn.click();
    }

    @Then("user deselect all options exept Title")
    public void user_deselect_all_options_exept_Title() {
        for (WebElement each : calendarEventsPage.titlesColumnGridOptions) {
            if (each.getText().equals("Title")) {
                continue;
            }
            each.click();
        }

    }

    @Then("user verify that Title column still displayed")
    public void user_verify_that_Title_column_still_displayed() {
        String actual = Driver.getDriver().findElement(By.xpath("(//div[@class='grid-container']/table/thead)[1]//th[2]")).getText();
        Assert.assertEquals("TITLE", actual);
    }

    @Given("user click on Create Calendar event button")
    public void user_click_on_Create_Calendar_event_button() {
        calendarEventsPage.createCalendarEventBtn.click();
        calendarEventsPage.waitUntilLoaderMaskDisapear();
    }

    @Then("user expand Save and Close menu")
    public void user_expand_Save_and_Close_menu() {
        calendarEventsPage.expandSaveAndCloseBtn.click();
    }

    @Then("Verify that Save and Close, Save and New, Save options are available")
    public void verify_that_Save_and_Close_Save_and_New_Save_options_are_available() {
        Assert.assertTrue(calendarEventsPage.saveAndCloseOption.isDisplayed());
        Assert.assertTrue(calendarEventsPage.saveAndNewOption.isDisplayed());
        Assert.assertTrue(calendarEventsPage.saveOption.isDisplayed());

    }

    @Then("user click on Cancel button")
    public void user_click_on_Cancel_button() {
        calendarEventsPage.cancelBtn.click();
        calendarEventsPage.waitUntilLoaderMaskDisapear();
    }

    @Given("user verify that difference between end and start time is exactly {int} hour")
    public void user_verify_that_difference_between_end_and_start_time_is_exactly_hour(Integer int1) {
        String startTime = calendarEventsPage.startTime.getAttribute("value");
        String endTime = calendarEventsPage.endTime.getAttribute("value");
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm aa");

        try {
            Date start = sf.parse(startTime);
            Date end = sf.parse(endTime);
            long dif = end.getTime() - start.getTime();
            long difH = dif / (60 * 60 * 1000);
            if (calendarEventsPage.startDate.getAttribute("value").equals(calendarEventsPage.endDate.getAttribute("value"))) {
                Assert.assertEquals((long) int1, difH);
            } else {
                Assert.assertEquals(-11, difH);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Then("user select start time and verify end time")
    public void user_select_start_time_and_verify_end_time(List<Map<String, String>> datatable) {
        for (Map<String, String> each : datatable) {
            calendarEventsPage.startTime.click();
            Driver.getDriver().findElement(By.xpath("//ul[@class='ui-timepicker-list']/li[text()='" + each.get("start time") + "']")).click();
            Assert.assertEquals(each.get("end time"), calendarEventsPage.endTime.getAttribute("value"));


        }
    }

    @Then("user select All-Day Event checkbox")
    public void user_select_All_Day_Event_checkbox() {
        calendarEventsPage.allDayEventCheckBox.click();
    }

    @Then("user verify All-Day Event is selected")
    public void user_verify_All_Day_Event_is_selected() {

        Assert.assertTrue(calendarEventsPage.allDayEventCheckBox.isSelected());
    }

    @Then("user verify that start and end time input boxes are not displayed")
    public void user_verify_that_start_and_end_time_input_boxes_are_not_displayed() {
        calendarEventsPage.wait.until(ExpectedConditions.invisibilityOf(calendarEventsPage.startTime));
        calendarEventsPage.wait.until(ExpectedConditions.invisibilityOf(calendarEventsPage.endTime));
        Assert.assertFalse(calendarEventsPage.startTime.isDisplayed());
        Assert.assertFalse(calendarEventsPage.endTime.isDisplayed());
    }

    @Then("user verify that start and end date input boxes are displayed")
    public void user_verify_that_start_and_end_date_input_boxes_are_displayed() {
        Assert.assertTrue(calendarEventsPage.startDate.isDisplayed());
        Assert.assertTrue(calendarEventsPage.endDate.isDisplayed());
    }

    @Then("user select Repeat checkbox")
    public void user_select_Repeat_checkbox() {
        calendarEventsPage.repeatCheckBox.click();
    }

    @Then("user verify Repeat checkbox is selected")
    public void user_verify_Repeat_checkbox_is_selected() {
        Assert.assertTrue(calendarEventsPage.repeatCheckBox.isSelected());
    }

    @Then("user verify that Daily is selected by default and following options are available in drop down")
    public void user_verify_that_is_selected_by_default_and_following_options_are_available_in_drop_down(List<String> datatable) {
        Select s = new Select(calendarEventsPage.repeatDropDown);
        Assert.assertEquals("Daily", s.getFirstSelectedOption().getText());
        List<String> l1 = new ArrayList<>();
        for (WebElement each : s.getOptions()) {
            l1.add(each.getText());
        }
        for (String each : datatable) {
            Assert.assertTrue(l1.contains(each));
        }

    }

    @Then("user verify that Repeat Every radio button is selected")
    public void user_verify_that_Repeat_Every_radio_button_is_selected() {
        Assert.assertTrue(calendarEventsPage.repeatEveryRadioBtn.isSelected());
    }

    @Then("user verify that “Never” radio button is selected as an Ends option")
    public void user_verify_that_Never_radio_button_is_selected_as_an_Ends_option() {
        Assert.assertTrue(calendarEventsPage.neverRadioBtn.isSelected());
    }

    @Then("user verify that following message as a summary is displayed: {string}")
    public void user_verify_that_following_message_as_a_summary_is_displayed(String str) {
        Assert.assertTrue(calendarEventsPage.summuryMes.isDisplayed());
        Assert.assertEquals(str, calendarEventsPage.summuryMes.getText());
    }

    @Then("user select After {string} occurrences option")
    public void user_select_After_occurrences_option(String occurr) {
        calendarEventsPage.afterRadioBtn.click();
        calendarEventsPage.afterInput.sendKeys(occurr, Keys.ENTER);

    }

    @Then("user select By {string} as End option")
    public void user_select_By_as_End_option(String date) {
        calendarEventsPage.byRadioBtn.click();
        calendarEventsPage.byInput.sendKeys(date);
    }

    @Then("user select {string} options as a Repeat option")
    public void user_select_options_as_a_Repeat_option(String option) {
        Select s = new Select(calendarEventsPage.repeatDropDown);
        s.selectByValue(option);
    }

    @Then("user select following options from datatable as a Repeat on options")
    public void user_select_following_options_from_datatable_as_a_Repeat_options(List<String> dataTable) {

        for (String each : dataTable) {
            Driver.getDriver().findElement(By.cssSelector(".multi-checkbox-control__item>input[value='"+each+"']")).click();
        }
    }

    @Then("user verify that following options from datatable are selected")
    public void user_verify_that_following_options_from_datatable_are_selected(List<String> dataTable) {
        for (String each : dataTable) {
            Assert.assertTrue(Driver.getDriver().findElement(By.cssSelector(".multi-checkbox-control__item>input[value='"+each+"']")).isSelected());
        }
    }

}
