Feature: Deliver To functionality
  Background:
    Given User is on "Home Page"

  Scenario Outline: Change delivery address using valid Zip Code

    When User clicks on the Deliver To button in the "Home Page"

    Then User can enter and apply the zip code "<zipcode>" and continue to "Home Page"

    And "<zipcode>" will be updated in the Delivery field in the "Home Page"

    Examples:
    |zipcode|
    |85001  |

  Scenario Outline: Change delivery address using invalid Zip Code (Negative Testing)

    When User clicks on the Deliver To button in the "Home Page"

    Then User can enter and apply an invalid zip code "<zipcode>"

    And User will be notified with "Please enter a valid US zip code" error message

    Examples:
      |zipcode |
      |------  |
      |ffffff  |
      |asdff-  |
      |...,31  |

    Scenario Outline: Verifying that a region is present in the drop down list in the Deliver To section

      When User clicks on the Deliver To button in the "Home Page"

      Then User is able to find the "<Country>" in the drop down list

      Examples:
      |Country|
      |Poland |
      |Myanmarr|








