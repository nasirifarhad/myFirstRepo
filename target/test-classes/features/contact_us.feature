@contact_us @regression
Feature: WebDriver university contact us page

  @sanity  # we can add tags on any scenario and pass in in runner class
  Scenario: Validate successful submission
    Given I Access to university home page
    When I enter first name
    And I enter last name
    And I enter email
    And I write comment
    And I click on submit button
    Then I should see the successful submission message

    @smoke
  Scenario: Validate successful submission with - specific data
    Given I Access to university home page
    When I enter specific first name khanlalamama
    And I enter specific last name babakakatata
    And I enter specific email khanbabalalatata@mail.com
    And I write specific comment "where are you, how do you feel pazavank? hahahaha!!!"
    And I click on submit button
    Then I should see the successful submission message