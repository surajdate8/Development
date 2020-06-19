#Author :
#Date
#Description
@smoketestregression
Feature: feature to test login functionality

  @smoketest
  Scenario: Check login functionality
    Given user is on loging page
    When user enter username and password
    And click on login button
    Then user is navigated to the home page
