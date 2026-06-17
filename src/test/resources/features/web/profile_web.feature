
Feature: Profile

@regression
Scenario: Logout successfully
Given user already logged in and navigate to profile page
When user click logout
Then Success logout