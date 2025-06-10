Feature: Game Setup
  Checks that exploding kitten correctly triggers win condition

  Scenario: 5 players until one winner
    Given a new game is started with 5 players
    And only the player who draws last has a defuse card
    When exploding kittens are drawn by all players without defuse
    Then one player remains and is declared the winner
