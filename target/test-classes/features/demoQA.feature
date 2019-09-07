#Author: Manjunath Harakatti


Feature: Countries Rest API Test
  I want to use this template for my feature file
  
  
  @capital
  Scenario Outline: Verify Post Request In DemoQA
  
  Given Base URI for DemoQA
  And I add "bengluru" as "FirstName"
  And I add "Karnataka" as "LastName"
  And I add "RRNagar" as "UserName"
  And I add "9972" as "Password"
  And I add "rrnagar@gmail.com" as "Email"
  When I Request POST Method
  Then I Verify Status code "<statusCode>"
  And I Verify Staus message "<StatusMsg>"
  
  Examples:
  |statusCode|StatusMsg|
  |201|Operation completed successfully|
  |200|FAULT_USER_ALREADY_EXISTS|
