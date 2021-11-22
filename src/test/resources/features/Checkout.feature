
Feature: Checkout
  @wip
  Scenario Outline: User should be able to pay
    Given User enter the weathershopper
    And User click to buy moisturizers button
    And User navigate to "moisturizer" page
    And User add least expensive Aloe moisturizer
    And User click to Cart button
    And Verify user navigate to checkout page
    And User click to pay with card button
    And Verify shopping cart looks correct
    And User pays using the following credentials
      | email                 | test@test.com           |
      | card number           | <cardNumber>            |
      | expiration date month | <expirationDateMonth>   |
      | expiration date year  | <expirationDateYear>    |
      | CVC                   | <CVC>                   |
      | Zip Code              | <ZipCode>               |
    Then User click to pay button
    And Verify payment success message is displayed
    Examples:
      | cardNumber           | expirationDateMonth  |expirationDateYear| CVC  |ZipCode  |
      | 4242424242424242     | 12                   |25                |123   |123123   |
      | 4000056655665556     |12                    |26                |312   |111111   |
  @wip
  #end-to-end Test Case
  Scenario Outline: User should be able to pay
    Given User enter the weathershopper
    And User click to buy sunscreens button
    And User navigate to "sunscreen" page
    And User add least expensive "SPF-30" sunscreen
    And User click to Cart button
    And Verify user navigate to checkout page
    And User click to pay with card button
    And Verify shopping cart looks correct
    And User pays using the following credentials
      | email                 | test@test.com           |
      | card number           | <cardNumber>            |
      | expiration date month | <expirationDateMonth>   |
      | expiration date year  | <expirationDateYear>    |
      | CVC                   | <CVC>                   |
      | Zip Code              | <ZipCode>               |
    Then User click to pay button
    And Verify payment success message is displayed
    Examples:
      | cardNumber           | expirationDateMonth  |expirationDateYear| CVC  |ZipCode  |
      | 4242424242424242     | 12                   |25                |123   |123123   |
      | 4000056655665556     | 12                   |26                |312   |111111   |
