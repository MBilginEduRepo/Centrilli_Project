Feature: User work on the Fleet Module
  User Story:
    1. Verify that user can create a Vehicle Fuel Logs
    2. Verify that user cannot create a Vehicle Fuel Logs without selecting vehicle
    3. Verify that user can cancel creating by clicking Discard button
    4. Verify that page title is changed to the new Vehicle Fuel Logs value after user create the Vehicle Fuel Logs
    5. Verify that “Attachment” and Action buttons are displayed at the top of the page (after creating a new Vehicle Fuel Logs).
    6. Verify that user can find the new created Vehicle Fuel Logs value under Vehicle Fuel Logs list by using search box.
    7. Verify that user can change Vehicle Fuel Logs page display to Kanban / List / Graph
    8. Verify that user can change Vehicle Fuel Logs page number by right and left arrow, up right corner of screen.
    9- Verify that the number of Vehicle Fuel logs increased 1

    US 27 - Fleet / Vehicles / Vehicles Fuel Logs Function
    Accounts are:POSMANAGER
  Background: User is on Vehicle Fuel Logs module.
    Given user is on the login page
    When user types valid credentials
    And user clicks login button
    And user clicks More Button
    And user clicks Fleet Module
    Then user clicks Vehicles Fuel Logs Module

  Scenario: create a Vehicle Fuel Logs
    And user clicks Create Button
    And user choose Vehicle
    And user click Save Button
    And page title changes to the new Vehicle Fuel Logs value

    @wip
  Scenario: Verify that user cannot create a Vehicle Contract without selecting vehicle
    When user clicks Create Button
    And user clicks to Save button
    And user receives a warning popup message, means that he is unable to create a vehicle.
    Then user makes sure his Fuel Logs is NOT created by verifying page title stayed the same:

