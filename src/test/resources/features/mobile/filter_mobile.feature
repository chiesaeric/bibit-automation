Feature: Filter

@mobile
Scenario: Filter Name Descending
Given user open mobile application
When Click icon filter
When Choose filter "Name - Descending"
Then Name filtered to be descending the first name is "Test.allTheThings() T-Shirt (yellow)"
@mobile
Scenario: Filter Price Ascending
Given user open mobile application
When Click icon filter
When Choose filter "Price - Ascending"
Then Name filtered to be ascending the first price is "$ 15.99"