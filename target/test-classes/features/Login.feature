Feature: Library app login feature
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: librarian, student, admin

  @login
Scenario: login as librarian
  Given user is on the login page
  When user enters librarian username
  And user enters librarian password
  Then user should see dashboard


Scenario: login as student
  Given user is on the login page
  When user enters student username
  And user enters student password
  Then user should see dashboard