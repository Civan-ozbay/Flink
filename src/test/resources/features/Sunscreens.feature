Feature: Adding sunscreens to cart
  @wip
  Scenario:User should be able to add sunscreens to cart
    Given User enter the weathershopper
    And User click to buy sunscreens button
    Then User navigate to "sunscreen" page
    Given User add least expensive "SPF-50" sunscreen
    And Secondly User add least expensive "SPF-30" sunscreen
    And User click to Cart button
    Then Verify user navigate to checkout page