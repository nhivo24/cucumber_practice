Feature: Customer manager
Manager can add customer, open account, customers.

  Background: Manager is Logged In
  Given I navigate to the manager page

@addnewcustomer
	Scenario Outline: Add New Customer
	Given I click add new customer button
	When I enter Firstname as "<Firstname>", Lastname as "<Lastname>", Postcode as "<Postcode>"
	Then I click submit
	Examples:
	|Firstname|Lastname|Postcode|
	|Vo       |Nhi     |500000  |
	|         |        |40000   |
	
@openaccount
	Scenario Outline: Open Account
	Given I click Open Account
	When I choose customer name as "<customename>", currency as "<currency>"
	Then I click process
	Examples:
	|customename  |currency|
	|Harry Potter |Dollar  |
	|             |Pound   | 
		
@Customers
	Scenario: Search customers
	Given I click Customers
  When I enter the first name in the search bar
  Then I verify the search information

		




  
  

   