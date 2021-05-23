#Author: yatinko
@HomePage
Feature: HomePage

  Background: 
    Given User is already on HomePage

  @Sanity
  Scenario: check the title
    Given User is on HomePage
    Then check the title of the page

  @Sanity
  Scenario: Successful display of relevant products
    Given User is on HomePage
    When user enters <validSearchItem> & <validSearchCategory> in searchbar
    And clicks the Search button
    Then display relevant products
	
  Examples:
	| validSearchItem | validSearchCategory 		   |
    | apple macbook   |	Computers/Tablets & Networking |
    | apple iphone    | Cell Phones & Accessories      |

  @Ignore
  Scenario: Failure finding products
    Given User is on HomePage
    When user enters <invalidSearchItem> & <validSearchCategory> in searchbar
    And clicks the Search button
    Then display appropriate message
    	
  Examples:
	| invalidSearchItem | validSearchCategory 		     |
    | %%$$              | Computers/Tablets & Networking |
    | ^$DS$             | Cell Phones & Accessories      |

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
