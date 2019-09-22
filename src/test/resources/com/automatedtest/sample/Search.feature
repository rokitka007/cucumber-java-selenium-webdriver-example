Feature: Search

  Background: db
    Given A user navigates to HomePage

  @search @search_01
  Scenario Outline: Search Booking.com
    When a user searches for "Gdańsk"
    Then "Apartament Kapitański" is displayed in the first "<nbOfResultsToSearch>" results

    Examples:
      | nbOfResultsToSearch |
      | 5 |


  @search @search_02
  Scenario Outline: Search "<miasto>" in Booking.com
    When a user searches for "<miasto>"
    Then "<oferta>" is displayed in the first "<nbOfResultsToSearch>" results

    Examples:
      | miasto | oferta | nbOfResultsToSearch |
      | Kraków | B&B Hotel Krakow Centrum | 4 |
      | Malbork | U Marzeny | 5 |
      | Warszawa |Royal Park Apartment | 5 |


