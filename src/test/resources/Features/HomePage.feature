#Author: yatink
@HomePage
Feature: HomePage

  Background: 
    Given User is already on HomePage

  Scenario: check the title
    Given User is on HomePage
    Then check the title of the page

  Scenario: Successful display of relevant products
    Given User is on HomePage
    When user enters valid data in searchbar
    And clicks the Search button
    Then display relevant products

  Scenario: Failure finding products
    Given User is on HomePage
    When user invalid data in searchbar
    And clicks the Search button
    Then display appropriate message

  Scenario: Successful display of dropdown components
    Given User is on HomePage
    When user hovers cursor on navbar elements
    Then display navbar components

  Scenario: Successful navigation to appropriate page on clicking on an option
    Given User is on HomePage
    When user clicks on a navbar component
    Then navigate to the appropriate page

  Scenario: Successful navigation to appropriate page on clicking on a link in footer
    Given User is on HomePage
    When user clicks on a footer link
    Then navigate to the appropriate page
