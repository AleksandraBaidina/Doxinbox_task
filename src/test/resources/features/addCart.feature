Feature: Basic Shopping Test

  Scenario: Testing the adding item to a cart.
    Given Default user is login
    Then Change order of item from Z to A
  #left bottom cart has number 5
    Then Open a item card 5
    Then Verify that the cart is empty
    When Add item to the cart
    Then Add to cart text replaced with remove
    Then The number of items in the cart has increased