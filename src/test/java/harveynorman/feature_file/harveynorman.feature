Feature: Automate the testing of an e-commerce website main functionalities

  Scenario: Search for dining tables
    Given the user navigates to the e-commerce website homepage
    When the user locates the search bar and inputs the search query "Dining Tables"
    Then the search results page should load successfully
    And the search results should contain items relevant to the search query
