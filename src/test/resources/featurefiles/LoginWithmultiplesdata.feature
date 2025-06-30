#Author: your.email@your.domain.com
Feature: Login Functionality with Multiple Data Sets

Scenario Outline: Login with multiple sets of data
 Given browser should be open and naviagted to art of testing ecommerce website
  When I enter username "<username>" and password "<password>"
  And Click on login button
  Then I should see "<message>"

Examples:
  | username 	| password 				| message               				|
  | auth_user | auth_password   | ArtOfTesting Ecom     				|
  | user2    	| auth_password   | Invalid username or password! |
  | auth_user | admin123 				| Invalid username or password! |
  |	auth_user	| auth_password		| ArtOfTesting Ecom             |
