@smoke
Feature: Login
  As user, I want to be able to log in under different roles with username and password.

  Background:
    Given user is on login page


  Scenario Outline: Login as <role>
    Given user logs i n as a "<role>"
    And user verify "<subtitle>" subtitle is displayed
    Examples:
      | role          | subtitle        |
      | store manager | Dashboard       |
      | sales manager | Dashboard       |
      | driver        | Quick Launchpad |

  @negative_login
  Scenario Outline: Log in with invalid credentials
    Given user logs in with invalid credentials "<username>" and "<password>"
    Then use verify "Invalid user name or password." messege is displayed
    Examples:
      | username | password    |
      | invalid  | invalid     |
      | user42   | invalid     |
      | invalid  | UserUser123 |

