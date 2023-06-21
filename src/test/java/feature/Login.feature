Feature: Login feature

  Background: 
    Given User launches the Application

  @Login @valid @smoke @regression
  Scenario: Login with valid credentials
    When User enters the valid username and password
    And User clicks the Login button
    Then User should login and land on HomePage

  #parameterization--data driven
  @Invalid @parameterization
  Scenario Outline: Unsuccessfull Login with Invalid Credentials
    When User enters the username as "<username>" and password as "<password>"
    And User clicks the Login button
    Then User should see the appropriate error message

    Examples: 
      | username            | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin123 |
      
      
    Scenario: Unsuccessfull Login with Invalid Credentials
    When User enters the username as "admin@yourstore.com" and password as "admin"
    And User clicks the Login button
    Then User should see the appropriate error message

    

  #DataTable --data drive
  @DataTable
  Scenario: Unsuccessfull Login with Invalid Credentials
    When User enters the username and password and clicks on Login button
      | username            | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.co  | admin123 |
      | admin@yourstore.c   | a123     |
   Then User should see the appropriate error message
   
   
    #difference between data and parameterization is :---
    # 1)In parameterization we have to pass the parameter and it contains the Examples ....which contains the data that will be passed 
    # 2)In dataTable the data that needs to be passed can be in the middle or at the end i.e after When, And, Then or at the end.
    # 3)Datatable doesn't contain the Examples
    # 4) In datatable there is no need to pass the parameter, instead in the Steps definition directly only the data can be used.
