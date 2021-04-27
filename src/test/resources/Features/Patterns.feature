Feature: Patterns Feature
  AS A User
  I WANT TO be able to get all colors patterns from colorlovers api
  SO THAT i can use it for different processes

  Scenario: Make sure all colors patterns views number are greater than 4000
    Given The user is able to access color lovers api
    When Make a get request to color lovers api patterns EndPoint
    Then It should return success status code 200
    And All the patterns should have views numbers greater than 4000