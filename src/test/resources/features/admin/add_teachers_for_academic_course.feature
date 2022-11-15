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
    When Select item from 'select teachers' dropdown list
    And Save linked teachers count for English course from DB and list size from section
    And Click on 'X' button
    Then Popup is closed
    When Click on 'Add' button and open popup
    Then Check there is no selected item
    And Teacher for item is not displayed on the list
    And Check teacher for English course is not added in the DB

  @TC3.34.5 @Regression @Smoke
  Scenario: Check functionality of "Teachers" Multi-selected drop-list
    Given Click on the 'Teachers' drop-down list
    Then Check the search line placeholder
    And Check multi-select drop-down list is opened
    When Fill name of teacher ir
    Then Check matched items appeared below the Search line
