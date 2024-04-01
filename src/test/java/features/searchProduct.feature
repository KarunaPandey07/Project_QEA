
@tag
Feature: Search and Place the order for Products

  @tag1
  Scenario: Search experience for product search in both home and offers page. 
    Given User is on GreenCart Landing page
    When User searched with shortname "Tom" and extracted actual name of the product
    Then User searched with same shortname in offers page to check if product exist


  
