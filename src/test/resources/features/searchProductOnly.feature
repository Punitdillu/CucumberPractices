Feature: Search and place order for productonly
@SearchOnly
Scenario Outline: Search product In both Homepage

Given User navigated to Flipkart landing page
When  User search with ProductName <Product> and extract actual name of product

Examples:
| Product |
| Apple iPhone 14 (Blue, 128 GB) |





 