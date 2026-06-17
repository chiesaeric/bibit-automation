Feature: Explore

@ui
Scenario: Explore product successfully
Given user already logged in and navigate to explore page
When user click search product
When user search product "safe"
When click product
Then Go to detail product page