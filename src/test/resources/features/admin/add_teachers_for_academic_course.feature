Feature: This feature will cover academic course section of admin page, especially adding new teachers for courses,
  checking validations and DB integration

  Background: Login as admin, go to academic course section and select one of the existed courses
    Given Login as admin
    When Select courses section
    And Click on the English item in the list
    And Select Teachers section in the dashboard
    And Click on 'Add' button and open popup

  @TC3.34.4 @Regression @Smoke
  Scenario: Check functionality of 'X' icon on the "New Teacher" pop-up
    Given Click on the 'Teachers' drop-down list
    When Select item from 'select teachers' dropdown list
    And Save linked teachers count for English course from DB and list size from section
    And Click on 'X' button
    Then Popup is closed
    When Click on 'Add' button and open popup
    Then Check there is no selected item
    And Check teacher for item is not displayed on the list
    And Check teacher for English course is not added in the DB

  @TC3.34.5 @TC3.34.6 @Regression @Smoke
  Scenario: Check functionality of "Teachers" Multi-selected drop-list
    Given Click on the 'Teachers' drop-down list
    Then Check the search line placeholder
    And Check multi-select drop-down list is opened
    When Fill name of teacher ik
    Then Check matched items appeared below the Search line

  @TC3.34.7 @Regression @Smoke
  Scenario: Check validations of the teachers list in the "Add Teacher" Multi-selected drop-list
    Given Click on the 'Teachers' drop-down list
    When Fill name of teacher ik
    Then Check matched items appeared below the Search line
    And Save quantity of matched items result and clear search box
    When Fill name of teacher IK
    And  Check matched items appeared below the Search line
    Then Check result quantity is the same as was in the previous search
    Then Check only teachers who are added for subject linked to English course is displayed and can be selected

  @TC3.34.8 @Regression @Smoke
  Scenario: Check functionality of 'remove' students from "Teachers" Multi-selected drop-list(one by one)
    Given Click on the 'Teachers' drop-down list
    When Select item from 'select teachers' dropdown list
    Then Check selected items are shown with the 'x' icon
    And Click on 'X' button of the selected teacher
    And Check selected items are deleted from drop-list fragment

  @TC3.34.9 @Regression @Smoke
  Scenario: Check functionality of 'X' button (clear all selected items)
    Given Click on the 'Teachers' drop-down list
    When Select item from 'select teachers' dropdown list
    And Click on 'X' button of the teacher list
    And Check selected items are deleted from drop-list fragment

  @TC3.34.11 @Regression @Smoke
  Scenario: Check mandatoriness of teachers input filed
    When Click on 'Save' button
    Then Check error messages of blank selections
