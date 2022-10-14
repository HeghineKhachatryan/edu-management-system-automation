Feature: Admin page/ Teacher section functionality
  This feature will cover teacher section of admin page, especially: creating new teachers,
  adding new created teachers to database, checking functionality of different buttons on the given page.

  Background: Login as admin, select teachers section and click on create button
    Given Fill heghine9696@gmail.com and 2kB$8tU#1aO( fields
    And Click on 'login' button
    When Select teachers section
    And Click on create button on admin page

  @TC1.8.2 @Regression @Smoke
  Scenario: Check functionality of 'X' button in create popup
    And Fill in all required fields
    And Click on 'X' button
    And Click on create button on admin page
    Then Check all input fields are empty in create popup
    And Check teacher is not added in the DB

  @TC1.8.5 @Regression @Smoke
  Scenario: Check validations/errors for Teacher name, Teacher surname and Teacher email input fields
    And Fill in input fields more than 50 symbols
    And Click on 'Save' button
    Then Check error messages of more symbols filled input fields

  @TC1.8.7 @Regression @Smoke
  Scenario: Check mandatoriness of all input fields
    And Click on 'Save' button
    Then Check error messages of blank input fields

  @TC1.8.9 @Regression @Smoke
  Scenario: Check uniqueness of the Teacher email
    When Fill name John
    And Fill surname Smith
    And Fill existed email
    And Click on 'Generate password' button
    And Click on 'Save' button
    Then Check error message of existed email

  @TC1.8.11 @Regression @Smoke
  Scenario: Check functionality to create New Teacher using valid credentials
    When Fill in all required fields
    And Click on 'Generate password' button
    And Click on 'Save' button
    And Popup is closed
    Then Check teacher is added in the DB
    And User is created and displayed in the list

  @TC1.8.12 @Regression @Smoke
  Scenario: Check the possibility of creating new teacher with an existing "Teacher Name" and "Teacher Surname"
    When Fill in existed name, surname
    And Fill email non-existed@gmail.com
    And Click on 'Generate password' button
    And Click on 'Save' button
    Then Check teacher is not added in the DB
    And User is created and displayed in the list

  @TC1.8.13 @Regression @Smoke
  Scenario: Check how password is kept in DB
    And Fill in all required fields
    And Click on 'Generate password' button
    And Click on 'Save' button
    Then Check the teacher password is hashed in the DB




