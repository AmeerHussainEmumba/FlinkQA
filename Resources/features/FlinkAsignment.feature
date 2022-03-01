Feature: User will see the temperature and decide if they need Sunscreen or Moisturizer and then purchase it.

  Scenario: As a shopper, I need to check the temperature and deicide if i need Sunscreen or Moisturizer
    Given I navigate to the weatherShopperLandingPage
    And I make a selection of which product i want to buy
    And I purchase two items of the product
    Then I must be able to check if the transaction is complete
