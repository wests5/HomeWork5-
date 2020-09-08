@pojo
Feature: test pojo with cucumber

  Scenario: Student makes intro
    Given student say his info
      | name | age | batch |
      | Nick | 25  | 15    |
    And student say buy