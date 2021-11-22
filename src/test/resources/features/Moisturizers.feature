Feature: Adding moisturizers to cart
  @wip
  Scenario: User should be able to add moisturizers to cart
    Given User enter the weathershopper
    And User click to buy moisturizers button
    Then User navigate to "moisturizer" page
    Given User add least expensive Aloe moisturizer
    And User add least expensive Almond moisturizer
    And User click to Cart button
    Then Verify user navigate to checkout page