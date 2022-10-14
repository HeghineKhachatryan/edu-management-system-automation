Feature: UI of pages
  This feature checks all elements that must be present on certain web pages

  @TC1.7.1 @Regression
  Scenario: Check UI of Login page
    Then Check all elements are present in login page

  @TC1.7.7 @Regression
  Scenario: Check UI of super admin page
    Given Fill super@gmail.com and Sa1234567+ fields
    And Click on 'login' button
    Then Check all elements are present in super admin page

  @TC1.6.1 @Regression @Smoke
  Scenario: Check UI of create popup in super admin dashboard
    Given Fill super@gmail.com and Sa1234567+ fields
    And Click on 'login' button
    And Click on 'create' button and open popup
    Then Check all fields are present in create popup

  @TC1.8.1 @Regression @Smoke
  Scenario: Check UI of 'create' popup in admin dashboard/ teacher section
    When Fill heghine9696@gmail.com and 2kB$8tU#1aO( fields
    And Click on 'login' button
    When Select teachers section
    And Click on 'create' button and open popup
    Then Check all fields are present in create popup

  @TC1.10.1
  Scenario: Check UI of Admin page Students section
    Given Fill heghine9696@gmail.com and 2kB$8tU#1aO( fields
    And Click on 'login' button
    When Select students section
    Then See all elements are present in student section