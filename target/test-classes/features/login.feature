@login @regression
#its for running 'feature file' from runner class by passing this in tags
  #and if we add another tag '@regression' like above in both contact_us and login feature files
  #and just pass it in 'runner class' it will be run all feature files that have @regression
Feature: webdriver university login page


  Background:
    Given I access the login page

  Scenario: login with valid credentials
    When I enter valid user name
    And I enter valid password
    And click on login button
    

  Scenario: login with invalid credentials
    When I enter invalid user name
    And I enter invalid password
    And click on login button

    Scenario Outline:
      When I enter a <username>
      And I enter  a <password>
      And click on login button
      Then I should get the <expectedMsg>
      Examples:
      |username  |password    |expectedMsg       |
      |webdriver |webdriver123|validation succeeded|
      |webdriver2|webdriver2  |validation failed   |
      |webdriver3|webdriver3  |validation failed   |
      |webdriver4|webdriver4  |validation failed   |