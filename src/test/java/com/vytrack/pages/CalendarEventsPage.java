package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import io.cucumber.java.en_lol.WEN;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {
    public CalendarEventsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//table/tbody//td[9]")
    public List<WebElement> threeDotsTbody;

    @FindBy(css="[title='Grid Settings']")
    public WebElement gridSettingsBtn;

    @FindBy(xpath = "//div[@class='table-wrapper']/table[@class='grid table-hover table table-condensed']/tbody//td[1]")
    public List<WebElement> titlesColumnGridOptions;

    @FindBy(xpath = "//*[@title='Create Calendar event']")
    public WebElement createCalendarEventBtn;

    @FindBy(css = "[class='btn-success btn dropdown-toggle']")
    public WebElement expandSaveAndCloseBtn;

    @FindBy(xpath = "//li/button[contains(text(), 'Save and Close')]")
    public WebElement saveAndCloseOption;

    @FindBy(xpath = "//li/button[contains(text(), 'Save and New')]")
    public WebElement saveAndNewOption;

    @FindBy(xpath = "//li/button[normalize-space()='Save']")
    public WebElement saveOption;
    @FindBy(css = "[title='Cancel']")
    public WebElement cancelBtn;
    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    public WebElement startTime;
    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    public WebElement endTime;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;
    @FindBy(css = "[id^='oro_calendar_event_form_allDay']")
    public WebElement allDayEventCheckBox;
    @FindBy(css = "input[id^='recurrence-repeat']")
    public WebElement repeatCheckBox;
    @FindBy(css = "select[id^='recurrence-repeat']")
    public WebElement repeatDropDown;

    @FindBy(xpath = "//span[text()='day(s)']/../input[@type='radio']")
    public WebElement repeatEveryRadioBtn;

    @FindBy(xpath = "//span[text()='Never']/preceding-sibling::input")
    public WebElement neverRadioBtn;

    @FindBy(xpath = "//label[text()='Summary:']/../following-sibling::div/div")
    public WebElement summuryMes;

    @FindBy(xpath = "//span[text()='After']/preceding-sibling::input")
    public WebElement afterRadioBtn;

    @FindBy(xpath = "//span[text()='After']/following-sibling::input")
    public WebElement afterInput;

    @FindBy(xpath = "//span[text()='By']/preceding-sibling::input")
    public WebElement byRadioBtn;

    @FindBy(xpath = "//span[text()='By']/../following-sibling::span//input[@placeholder='Choose a date']")
    public WebElement byInput;

    @FindBy(css = ".multi-checkbox-control__item>input")
    public List<WebElement> repeatOnDayOptions;
}
