@non-reg
Feature: As a user I want to login to my account

  @Login
  Scenario: Login scenario
    Given user is on the home page
    #When  user enters his "<mail>" and his "<password>"
    When  user enters his
    Then  user should be logged in
    #Examples:
    #  | mail            | password    |
    #  | wass@gmail.com  | wass        |