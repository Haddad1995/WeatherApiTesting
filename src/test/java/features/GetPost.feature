Feature:
  Verify Get Operation Using RestAssured

  Scenario: Verify Status Code
    Given I perform Get Operation for "v1/forecast?latitude=52.52&longitude=13.41&current_weather=true&timezone=auto"
    Then I should see the status code as "200"