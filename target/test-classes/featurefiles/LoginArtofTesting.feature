#Author: lokeshchinna793@gmail.com

@Login
Feature: Login functionality of art of testing ecommerce website
Background:
Given browser should be open and naviagted to art of testing ecommerce website

@Sanity
Scenario: Ensure user should login with valid credentials
When enter valid username and valid password 
And Click on login button
Then verify login successfull


@Regression @Smoke
Scenario: Ensure user should login with invalid credentials
When enter valid username and invalid password 
And Click on login button
Then verify login unsuccessfull

