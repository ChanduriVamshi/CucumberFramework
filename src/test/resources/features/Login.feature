Feature: User Login
#Registered user should be able to login

	Background: 
		Given User navigates to login page
		
  #@LoginWithValidCredentials @smoke @regression
  Scenario: Login with valid credentials
    When User enters valid username "Admin" and valid password "admin123"
		And User clicks on login
    Then User should be able to login successfully

  #@LoginWithInvalidCredentials @regression
  # Scenario Outline: Login with invalid credentials
  #   When User enters invalid username <uname>
  #   And User enters invalid password <pwd>
  #   Then User should not be able to login successfully

  #   Examples: 
  #     | uname  	 | pwd 		  |
  #     | abcd     | 12345678 |
  #     | 1234     | abcdefgh |
  #     | @#$%     | &^%$%    |