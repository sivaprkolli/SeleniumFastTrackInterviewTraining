Feature: Sauce Login

  Background:
    Given User on landing page

  @Test1 @Smoke1
  Scenario: Verify successful login with valid credentials
  #  Given User on landing page
    When User enter valid credentials
    Then User navigated to products page

  @Test2 @Regression
  Scenario: Verify unsuccessful login with invalid credentials
    When User enter invalid credentials "standard_user" and "password"
    Then User navigated to products page

  @Test3 @Smoke @Regression
  Scenario Outline: Verify unsuccessful login with valid credentials
    When User enter invalid credentials "<username>" and "<password>"
    Then User navigated to products page
    And User logout

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | standard_user | secret_sauce |
      | standard_user | secret_sauce |


  @Regression
  Scenario: Verify unsuccessful login with invalid username
    When User enter invalid username and valid password
      | username | standard_user |
      | password | secret_sauce  |
    Then User navigated to products page