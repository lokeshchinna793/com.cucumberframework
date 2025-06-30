#Author: lokeshchinna@gmail.com

Feature: Orangae HRM

Scenario Outline: Login with multiple sets of data
 Given browser should be open and naviagted to Orange HRM
  When I enter username "<username>" and password "<password>" from feature file
  And Click on login button for OrangeHrM
  Then I should see meassage as like "<message>" 

  Examples:
	| username |	password | message 								|
	| Admin 	 |	admin123 | Lokesh Login Successful	|
	| username |	admin 	 | Loki Login UNSuccessful 	|
	| Admin 	 |	admin123 | Chinna Login Successful	|