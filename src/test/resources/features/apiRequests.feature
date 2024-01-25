Feature: API tests

  Scenario: Test get request
    Given Send get request with page number 2
    Then Verify status code 200
    And Verify that first name Lindsay is exist
    And Verify body contains field page with numerical value 2


  Scenario: Test post request
    Given Create user with random name and job
    Then Verify status code 201
    And Verify returned name
    And Verify returned job

