Feature: Amazon Search Functionality

  Background: Make Sure Your Browser Is Open & You Are Always On Amazon Page
    When user navigates to amazon url
    Then amaozon website should be displayed

  @smoke
  Scenario: Test Amazon Search Product Functionality
    Given user enters "Alexa" in searchbox
    When user clicks on search button
    Then user verifies search result
