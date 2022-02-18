Feature: User will see the temperature and decide if they need Sunscreen or Moisturizer

  Scenario: As a shopper, I need to check the temperature and if it is below 19 I need to click on Moisturizer, and if it is above 34 I need to click on Sunscreen
    Given I navigate to the weatherShopperLandingPage
    And I make a selection of which product i want to buy
    And I purchase two items of the product
    Then I must be able to check if the transaction is complete
