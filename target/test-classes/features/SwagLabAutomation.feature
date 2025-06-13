Feature: This feature file contains end to end testcases for Swag Labs site automation 

Scenario: Scenario is to Login on Swag labs and add any 2 products in cart and order them by adding All order details.
          
          Given Enter Url
          And Enter username "<username>" and password "<password>" 
          When click on Login
          Then Check is Login successfull
          And is Inventory Page displayed
          Then add products to cart
          And Go to cart section
          Then check Products added into cart or not
          And Click on checkoutButton
          Then Enter Order details 
          And Finish order 
          Then check is order Complete
          And Take Order confirmation screenshot
          
          
 Examples:
  | username | password |
  | standard_user    | secret_sauce | 