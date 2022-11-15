Feature:
  Verify Get operation with parameters using Rest Assured

  Scenario: Verifying Temperature of the Current Weather
    Given I perform Get Operation for "/v1/forecast?latitude={latitude}&longitude={longitude}&current_weather={current_weather}&timezone={timezone}" with Params
    |latitude|longitude|current_weather|timezone| temperature|
    | 52.52  |  13.41   |     true     |  auto  |   7.6    |
    Then I should see the temperature as "7.6"