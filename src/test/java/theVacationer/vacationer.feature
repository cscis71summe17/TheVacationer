Feature: Should be possible to receive various destinations per country/city
  Scenario: Ensure Cucumber is working properly.
    Given I have a scenario
    When I run the tests
    Then all the tests go green

  Scenario: Determine the validity of returned restaurants
    Given A specific location of Paris, France
    When I chose to locate available restaurants
    Then there are 5 valid restaurants

  Scenario Outline: Determine whether each city of a given country returns 5 restaurants
    Given a city "<city-chose>" in "<country-chose>"
    When  I chose to locate restaurant information
    Then  the system should return the top "<res-num>" restaurants
    Examples:

      | city-chose | country-chose | res-num |
      |   Munich   |    Germany    |    5    |
      |   Rome     |    Italy      |    5    |
      |   Milan    |    Italy      |    5    |
      |   Paris    |    France     |    5    |

  Scenario:
    Given A specific landmark location in Paris, France
    When I chose to locate top landmarks
    Then there are 5 valid landmarks

  Scenario Outline: Determine whether each city of a given country returns 5 landmarks
    Given a city "<city-chose>" in "<country-chose>"
    When  I chose to locate landmark information
    Then  the system should return  "<res-num>" landmarks
    Examples:

      | city-chose | country-chose | res-num |
      |   Munich   |    Germany    |    5    |
      |   Berlin   |    Germany    |    0    |
      |   Rome     |    Italy      |    5    |
      |   Milan    |    Italy      |    5    |


