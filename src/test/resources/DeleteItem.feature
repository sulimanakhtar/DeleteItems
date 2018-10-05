Feature: As a customer i can delete unwanted items

Scenario: Customer can delete items from the shopping cart
When Customer is at home page
And Clicks on shop
And Clicks on buy button to add items to cart
And Clicks on cart
And Add quantity
And Delete items 
Then Item should be removed from the shopping cart
And Close the browser