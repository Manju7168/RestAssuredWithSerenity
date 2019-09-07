#Author: Manjunath Harakatti

@tag
Feature: Countries Rest API Test
  I want to use this template for my feature file

  @name
  Scenario: Verify Country Name
  
  Given Base URI
  When I get Information of "INDIA"
  Then I Verify "Republic of India" in the response
  
   @capitaltest
  Scenario: Verify Country Capital
  
  Given Base URI
  When I get Information of "norway"
  Then I Verify "Oslo" in the response
   
