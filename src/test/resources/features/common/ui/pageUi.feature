Feature: UI of pages
  This feature checks all elements that must be present on certain web pages

  @TC1.7.1 @Regression
  Scenario: Check UI of Login page
    Then Check all elements are present in login page

  @TC1.7.7 @Regression
  Scenario: Check UI of super admin page
    Given Enter super@gmail.com and Sa1234567+ fields
    And Click on 'login' button
    Then Check all elements are present in super admin page
