Feature: Test login functionality

  Scenario Outline: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters <username> and <password>
    Then usr is navigated to the home page

    Examples: 
      | username   | password |
      | surajdate8 |    12345 |
      | suraj      |    12345 |
