Feature: Go Boston test feature

Scenario: Buy four choice explorer pass
    Given I am on the home page
    And I navigate to the explorer page
    And I select four choice pass
    When I click on checkout button
    Then I should go to review your order page
    And I select visiting date
    When I press continue to payment button
    Then I should see the payment page