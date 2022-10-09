Feature: Login as different users
  User will be able to login as different users (for example as super admin, admin and so on), also in this
  feature will be covered unsuccessfully login attempts and error messages

  @TC1.7.2 @Regression @Smoke
  Scenario: Check super admin logs in successfully
    Given Enter email super@gmail.com in login page
    And Enter password Sa1234567+ in login page
    And Click on 'login' button
    Then The user is on super admin page

  @TC1.7.3 @TC1.7.4 @Regression
  Scenario Outline: Checking displayed error messages while using incorrect credentials during login
    When Enter <email> and-or <password> fields
    And Click on 'login' button
    Then See error message

    Examples:
      | email         | password      |
      | wrongUsername | wrongPassword |
      |               | blankUsername |
      | blankPassword |               |
      |               |               |

  @TC1.7.6 @Regression
  Scenario: Check ability to login as an admin using last generated password after creating new admin
    Given Enter email super@gmail.com in login page
    And Enter password Sa1234567+ in login page
    And Click on 'login' button
    And Click on 'create' button and open popup
    And Fill in all required fields
    And Click on 'Generate password' button
    And Click on 'Save' button
    Then Sign in as admin with generated password
