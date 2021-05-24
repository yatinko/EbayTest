Feature: eBay Product Page

Scenario: visit the search result page
Given user is on home page
When user click on motors menu
Then search result page appears

Scenario Outline: Adding shipping location
Given user is on product page 
When user click on shipping to section
Then user choose "<country>" and enter valid "<pincode>"
And click on Go button
Then shipping location is set

Examples:
|country|pincode|
|India - IND|400030|
|Ghana - GHA||