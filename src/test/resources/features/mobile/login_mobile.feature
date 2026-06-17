Feature: Login

@mobile
Scenario: Login Success
Given user open mobile application
When Click burger icon
When Click login menu
When Input username "bod@example.com" 
When password "10203040"
When click button login
Then Login successfully