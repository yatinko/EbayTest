#Author: yatink
@HomePage
Feature: HomePage

  Background: 
    Given User is already on HomePage

  @Sanity
  Scenario: check the title
    Given User is on HomePage
    Then check the title of the page
    Then User quits browser

  @Ignore
  Scenario: Successful display of relevant products
    Given User is on HomePage
    When user enters valid data in searchbar
    And clicks the Search button
    Then display relevant products

  @Ignore
  Scenario: Failure finding products
    Given User is on HomePage
    When user invalid data in searchbar
    And clicks the Search button
    Then display appropriate message

  @Ignore
  Scenario: Successful display of dropdown components
    Given User is on HomePage
    When user hovers cursor on navbar elements
    Then display navbar components

  @Ignore
  Scenario: Successful navigation to appropriate page on clicking on an option
    Given User is on HomePage
    When user clicks on a navbar component
    Then navigate to the appropriate page

  @Ignore
  Scenario: Successful navigation to appropriate page on clicking on a link in footer
    Given User is on HomePage
    When user clicks on a footer link
    Then navigate to the appropriate page
