Feature: Show records functionality

  @wip
  Scenario: Verify default values in Users page
    Given user is logged in
    When user clicks on Users link
    Then show records dropdown value should be 10 by default
    And show records should have following options:
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |