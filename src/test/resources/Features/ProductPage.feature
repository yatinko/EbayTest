Feature: eBay Product Page

#Scenario: visit the search result page
#Given user is on home page
#When user click on motors menu
#Then search result page appears

#Scenario Outline: Adding shipping location
#Given user is on product page 
#When user click on shipping to section
#Then user choose "<SheetName>" and enter valid <RowNumber>
#And click on Go button
#Then shipping location is set
#
#Examples:
#|SheetName|RowNumber|
#|country_pincode|0|
#|country_pincode|1|
#|country_pincode|2|

#Scenario Outline: Failure in adding shipping location on wrong pin code input
#Given User is on product page in motors category
#When user choose "<SheetName>" and enter <RowNumber> of wrong pincode
#And click Go button
#Then display error message
#
#Examples:
#|SheetName|RowNumber|
#|wrong_pincode|0|
#|wrong_pincode|1|

Scenario: Failure in adding shipping location on wrong pin code input
Given User is on product page in motors category
When user select city and enter wrong pincode
And click Go button
Then display error message
