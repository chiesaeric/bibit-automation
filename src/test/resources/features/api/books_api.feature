Feature: Books API

@api
  Scenario: Create data books successfully
    Given user create new book with title "Learn API Testing" and body "Practicing API testing with JSONPlaceholder" and userId "101"
    Then response status should be 201
    And response should contain title "Learn API Testing" and body "Practicing API testing with JSONPlaceholder" and userId "101"
@api
  Scenario: Collect data books successfully
    Given user get all books data
    Then response status should be 200
    And response should id should not be null
@api
  Scenario: Delete data books successfully
    Given user delete id "1"
    Then response status should be 200
@api
  Scenario: Update data books successfully
    Given user update id "1" title "Updated Post Title" and body "This is the updated body content." and userId "99"
    Then response status should be 200
    And response should contain title "Updated Post Title" and body "This is the updated body content." and userId "99"