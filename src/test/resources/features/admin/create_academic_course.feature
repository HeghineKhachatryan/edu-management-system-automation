Feature: This feature will cover academic course section of admin page, especially creating new courses,
  adding teachers to the created courses, checking validations according the given requirements and database integration.

  Background:
    Given Login as admin
    When Select courses section
    Then Click on 'create' button and open popup

  @TC3.21.4 @Regression
  Scenario: Check functionality of 'X' icon on the "New Subjects" pop-up
    Given Fill academic course name
    And Select subject
    When Click on 'X' button
    Then Popup is closed
    And Click on 'create' button and open popup
    And Check academic course name field and drop down list are empty in courses section create popup
    And Check blank input fields error messages are not displayed
    And Check academic course is not added in the DB

  @TC3.21.5 @Regression
  Scenario: Check functionality of "Subject" drop-down
    Given Click on 'Subject' select and check dropdown opens with list of subjects
    When Select subject
    And Save value of selected subject
    Then Check the user choice is displayed in the 'Subject' field

  @TC3.21.6 @Regression
  Scenario: Check the creation of new academic course after inputting valid data in mandatory fields
    Given Fill academic course name
    And Select subject
    When Click on 'Save' button
    Then Popup is closed
    And Check academic course is displayed in the list
    And Check academic course is added in the DB

  @TC3.21.8 @Regression
  Scenario: Check the creation of the new academic course  without selecting subject
    Given Fill academic course name
    When Click on 'Save' button
    Then Check error messages of blank input fields

  @TC3.21.9 @Regression @Smoke
  Scenario: Check the uniques of the Academic Course Name
    Given Fill existed academic course name
    And Select subject
    When Click on 'Save' button
    Then Check error message of existed academic course name

  @TC3.21.10 @Regression @Smoke
  Scenario: Check case sensitivity of academic course name
    Given Fill case sensitive existed academic course name
    And Select subject
    When Click on 'Save' button
    Then Check error message of existed academic course name
