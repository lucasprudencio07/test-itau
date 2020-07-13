Feature: Automate some tests on the iCarros site

  @this
  Scenario: Create a list that will return at least 3 cars
    Given I am on the home page
    When I select the brand and the car model
    Then a list based on my filter will be returned


  Scenario Template: Validade the model and the price from the first 2 cars based on the search
    Given I have a list on cars based on the brand and car model
    When I pick up some field on the annoucement
    Then the price will be <price> of an <model> on the position <index>

    Examples:
      | index |                   model                 |     price       |
      |   0   | "Ecosport SE 1.5 (Aut) (Flex)"          | "R$ 64.890,00"  |
      |   1   | "EcoSport SE Direct 1.5 (Aut) (Flex)"   | "R$ 64.900,00"  |


  Scenario: Read the entire list and save in a file with the necessary data
    Given I need to read the vehicle list
    When I create a csv file
    Then all the car data need to be saved into this file


  Scenario: Read the list and validate the values inside it
    Given I have a list of vehicles
    When I need to read the vehicle list
    Then I need to validate all the data