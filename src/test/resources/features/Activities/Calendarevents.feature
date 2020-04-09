@calendar_events

Feature: calendar events

  Background:
    Given user is on login page
    Then user logs in as a "store manager"
    And user navigate to "Activities" and then to "Calendar Events"

  @TC1
  Scenario: Verify that view, edit and delete options are available
    Given user hover over three dots for random event
    And user verify that view, edit and delete options are available

  @TC2
  Scenario: Verify that Title column still displayed
    Given user click on Grid Options button
    Then user deselect all options exept Title
    And user verify that Title column still displayed

  @TC3
  Scenario: Verify that “Save And Close”, “Save And New” and “Save” options are available
    Given user click on Create Calendar event button
    Then user expand Save and Close menu
    And Verify that Save and Close, Save and New, Save options are available


  @TC4
  Scenario: Verify that “All Calendar Events” page subtitle is displayed
    Given user click on Create Calendar event button
    Then user click on Cancel button
    And user verify "All Calendar Events" subtitle is displayed

  @TC5
  Scenario: Verify that difference between end and start time is exactly 1 hour
    Given user click on Create Calendar event button
    And user verify that difference between end and start time is exactly 1 hour

  @TC6
  Scenario: Verify that end time is equals to
    Given user click on Create Calendar event button
    Then user select start time and verify end time
      | start time | end time |
      | 9:00 PM    | 10:00 PM |
      | 6:00 AM    | 7:00 AM  |
      | 4:00 PM    | 5:00 PM  |

  @TC7
  Scenario: Verify All Day Event checkbox
    Given  user click on Create Calendar event button
    Then user select All-Day Event checkbox
    And user verify All-Day Event is selected
    Then user verify that start and end time input boxes are not displayed
    And user verify that start and end date input boxes are displayed

  @TC8
  Scenario: Verify Repeat functionality
    Given  user click on Create Calendar event button
    Then user select Repeat checkbox
    And user verify Repeat checkbox is selected
    Then user verify that Daily is selected by default and following options are available in drop down
      | Daily   |
      | Weekly  |
      | Monthly |
      | Yearly  |


  @TC9
  Scenario: Verify repeat options
    Given  user click on Create Calendar event button
    Then user select Repeat checkbox
    And user verify Repeat checkbox is selected
    Then user verify that Repeat Every radio button is selected
    And  user verify that “Never” radio button is selected as an Ends option
    And user verify that following message as a summary is displayed: "Daily every 1 day"


  @TC10
  Scenario: Verify after 10 occurrences option
    Given  user click on Create Calendar event button
    Then user select Repeat checkbox
    And user select After "10" occurrences option
    Then user verify that following message as a summary is displayed: "Daily every 1 day, end after 10 occurrences"


  @TC11
  Scenario: Verify Ends by date option
    Given  user click on Create Calendar event button
    Then user select Repeat checkbox
    And user select By "Nov 18, 2021" as End option
    Then user verify that following message as a summary is displayed: "Daily every 1 day, end by Nov 18, 2021"


  @TC12
  Scenario: Verify Weekly options as a Repeat option
    Given  user click on Create Calendar event button
    Then user select Repeat checkbox
    And user select "weekly" options as a Repeat option
    And user select following options from datatable as a Repeat on options
      | monday |
      | friday |
    Then user verify that following options from datatable are selected
      | monday |
      | friday |
    Then user verify that following message as a summary is displayed: "Weekly every 1 week on Monday, Friday"

