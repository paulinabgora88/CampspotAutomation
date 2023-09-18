Feature: Verify Camp Search Functionality

  Scenario: Verify user can search camp sites
    Given user open website
    Then verify user is on homepage
    When user enters the location "camp.location"
    And select check in date "camp.valid.check-in.date"
    And select checkout date "camp.valid.check-out.date"
    And select number of guest "camp.number.of.guest"
    And click on search button
    Then verify user is on camp listing page

