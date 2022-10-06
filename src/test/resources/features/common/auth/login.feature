Feature: Login as different users

  Scenario: Check super admin logs successfully - TC 1.7.2
    Given Enter email super@gmail.com in login page
    And Enter password Sa1234567+ in login page
    And Click on 'login' button
    Then The user is on super admin page
