Feature: Register
  Perform Registration

  @register-feature
  Scenario: Tap register button and show dashboard screen
    Given I am on register screen
    When I tap register button
    Then I should see dashboard screen