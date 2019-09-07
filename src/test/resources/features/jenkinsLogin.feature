#Author: Manjunath Harakatti


Feature: Jenkins Rest API Test
  I want to use this template for my feature file
  
  
  @jenkinsPos
  Scenario: Verify Jenkins Rest API login (Positive)
  
  Given Base URI for Jenkins
  When I login jenkins with valid Credentials
  Then I Verify Status code "200"
  
  @jenkinsNeg
  Scenario: Verify Jenkins Rest API login (Negative)
  
  Given Base URI for Jenkins
  When I login jenkins with Invalid Credentials
  Then I Verify Status code "401"
  Then I Verify Staus message "Invalid password/token for user"
