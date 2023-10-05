Feature: Search a car

  Scenario: Search for a car by given marka and maximum price
    Given the user has navigated to "https://www.mobile.bg/"
    When the user selects "Audi" from dropdown
    And the user fills out the maximum price field with random price
    And the user clicks on the Search button
    Then the results from the search are shown to the user
