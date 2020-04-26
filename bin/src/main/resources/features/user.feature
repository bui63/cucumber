Feature: user wants to check  employee crud operation
  @getUserByIdTest
  Scenario Outline: user checks for GET By ID operation
    Given user launches the application and send getById request
    When  user gives id <ID> to see a particular record
    Then  user recevies the id <ID>, name <Name>, dob <DOB>

    Examples:
    Examples:
      | ID | Name   | DOB                      |
      | 1  | Rahul1 | 2020-04-25T03:07:19.993Z |
      | 2  | Rahul2 | 2020-04-25T03:07:19.993Z |


  @postUserTest
  Scenario Outline: user wants to Add Users record
    When user sends POST HTTP request
    Then  user adds  dob <dob>, id <ID> and name<Name>


    Examples:
      | dob                      | ID | Name   |
      | 2020-04-25T03:07:19.993Z | 1  | Rahul1 |
      | 2020-04-25T03:07:19.993Z | 2  | Rahul2 |


