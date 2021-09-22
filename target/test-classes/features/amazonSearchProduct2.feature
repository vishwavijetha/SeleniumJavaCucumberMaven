Feature: Amazon Search Functionality

Background: Make Sure Your Browser Is Open & You Are Always On Amazon Page
    When user navigates to amazon url
    Then amaozon website should be displayed

  @smoke
  Scenario Outline: Test Amazon Search Product Functionality
    Given user enters "<searchText>" in searchbox
    When user clicks on search button
    Then user verifies search result

    Examples: 
      | searchText |
      | Apple      |
      | Samsung    |
