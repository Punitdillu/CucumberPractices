Feature: Search and place order for product
@SearchAndAddToCart
Scenario Outline: Search product In both Homepage and offerpage

Given User is on Flipkart landing page
When  User search with shortName <Product> and extract actual name of product
Then Add product in cart
And Validate product <Product> added in cart or Not

Examples:
| Product |
| Apple iPhone 12 (Blue, 128 GB) |
| Apple iPhone 12 (Blue, 128 GB) |





 