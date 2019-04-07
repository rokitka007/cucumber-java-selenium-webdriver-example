Feature: Search


  @search @search_01
  Scenario Outline: Search Booking.com
    Given A user navigates to HomePage
    When a user searches for "Gdańsk"
    Then "Little Home - Kontinuum" is displayed in the first "<nbOfResultsToSearch>" results

    Examples:
      | nbOfResultsToSearch |
      | 5 |
