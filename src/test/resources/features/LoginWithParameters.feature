Feature: Login with parameters feature

  @lib11
  Scenario: Login as librarian 11
    Given user is on the login page
    When user enters username "librarian11@library"
    And user enters password "I61FFPPf"
    And user clicks the sign in button
    Then dashboard should be displayed

  @lib12
  Scenario: Login as librarian 12
    Given user is on the login page
    When user enters username "librarian12@library"
    And user enters password "AOYKYTMJ"
    And user clicks the sign in button
    Then dashboard should be displayed
    And there should be "24234" users
  #numbercan be whatever you have there


  Scenario: Login as librarian in same line
    Given user is on the login page
    When user login using credentials
      | username | librarian12@library |
      | password | AOYKYTMJ            |
    Then dashboard should be displayed
    And there should be "23" users
