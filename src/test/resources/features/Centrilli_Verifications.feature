@US_27
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

    Scenario: Verify that user can create a Vehicle Fuel Logs
      When user clicks Create Button
      And user choose Vehicle
      And user clicks Save Button
      And page title changes to the new Vehicle Fuel Logs value

    Scenario: Verify that user cannot create a Vehicle Fuel Logs without selecting vehicle
      When user clicks Create Button
      And user clicks Save Button
      And user receives a warning popup message, means that he is unable to create a vehicle.
      Then user makes sure his Fuel Logs is NOT created by verifying page title stayed the same:

    Scenario: Positive scenario:
              Verify that user can cancel creating by clicking Discard button
      When user clicks Create Button
      And user clicks to Discard button
      Then user makes sure his Fuel Logs is discarded by landing on the Vehicles Fuel Logs page

    Scenario:Negative scenario 1:
              Verify that user can cancel creating by clicking Discard button
      When user clicks Create Button
      And user choose Vehicle
      And user clicks to Discard button
      And user sees this warning message "The record has been modified, your changes will be discarded. Do you want to proceed?"
      And user clicks Ok button
      Then user sees the "Vehicles Fuel Logs" page

    Scenario: Verify that page title is changed to the new Vehicle Fuel Logs value after user create the Vehicle Fuel Logs
      When user clicks Create Button
      And user choose Vehicle
      And user clicks Save Button
      And page title changes to the new Vehicle Fuel Logs value

    Scenario: Verify that “Attachment” and Action buttons are displayed at the top of the page (after creating a new Vehicle Fuel Logs).
      When user clicks Create Button
      And user choose Vehicle
      And user clicks Save Button
      Then “Attachment” and Action buttons are displayed at the top of the page
  @wip
    Scenario Outline: Verify that user can find the new created Vehicle Fuel Logs value under Vehicle Fuel Logs list by using search box.
      When user clicks Create Button
      And user enters vehicle "<Vehicle>"
      And user enters Odometer Value <Odometer Value>
      And user enters Liter <Liter>
      And user enters Price Per Liter <Price Per Liter>
      And user enters Total Price <Total Price>
      And user enters Date "<Date>"
      And user enters Purchaser "<Purchaser>"
      And user enters Invoice Reference "<Invoice Reference>"
      And user enters Vendor "<Vendor>"
      And user enters Notes "<Notes>"
      And user clicks Save Button
      And user sees the "<Vehicle>" on the page
      And user returns to the Vehicle Fuel Logs List by clicking the Vehicles Fuel Logs button
      And user enters below data in the search box along with filters on the Filters page side.
      And user adds vehicle "<Vehicle>"
      #And user adds Odometer Value <Odometer Value>
      And user adds Liter <Liter>
      And user adds Price Per Liter <Price Per Liter>
      And user adds Total Price <Total Price>
      And user adds Date "<Date>"
      And user adds Purchaser "<Purchaser>"
      And user adds Invoice Reference "<Invoice Reference>"
      And user adds Vendor "<Vendor>"
      And user adds Notes "<Notes>"
      And user clicks Advanced Search... button
      Then user sees the "<new created>" Fuel Logs value.

      Examples:
        | Vehicle  | Odometer Value | Liter | Price Per Liter | Total Price | Date       | Purchaser | Invoice Reference | Vendor | Notes                   | new created |
        | Audi/A1/ | 2.00           | 200   | 2.0             | 400         | 03/24/2023 | Roksi     | Yavuz Limited     | Yalcin | Thanks you for services | Audi/A1/    |


    Scenario: Verify that user can change Vehicle Fuel Logs page display to Kanban / List / Graph
      When users clicks List buttons
      And user sees changed Fuel Logs display to List
      And users clicks Kanban buttons
      And user sees changed Fuel Logs display to Kanban
      And users clicks Graph buttons
      Then user sees changed Fuel Logs display to Graph




