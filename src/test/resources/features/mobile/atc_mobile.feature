Feature: Checkout

@mobile
Scenario: Checkout Success
Given user open mobile application and login with username "bod@example.com" and password "10203040"
When Click select product "Sauce Labs Backpack"
When Choose color "Blue"
When Choose Qty "2"
When Click button add to cart
When Go to cart page
When Click checkout
When Input name "Erik"
When Input address "Jl. Indra"
When Input city "Bekasi"
When Input zipcode "112233"
When Input country "Indonesia"
When Click payment
When Input card name "erik"
When Input card number "0011002200330044"
When Input card exp date "03/05"
When Input card security code "123"
When Click review order
When Click place order
Then checkout successfully