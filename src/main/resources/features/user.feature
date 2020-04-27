Feature: user wants to check crud operation

  @postUserTest
  Scenario Outline: user wants to Add Users record
    When user sends POST HTTP request
    Then  user adds  dob <dob>, id <ID> and name<Name>


    Examples:
      | dob        | ID | Name   |
      | 10-02-1997 | 1  | Rahul1 |
      | 10-02-1997 | 2  | Rahul2 |


  @getUserByIdTest
  Scenario Outline: user checks for GET By ID operation
    Given user launches the application and send getById request
    When  user gives id <ID> to see a particular record
    Then  user recevies the id <ID>, name <Name>, dob <DOB>


    Examples:
      | ID | Name   | DOB        |
      | 1  | Rahul  | 10-02-1997 |
      | 2  | Rahul2 | 10-09-1994 |