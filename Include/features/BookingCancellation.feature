@tag
Feature: Refund
  
  Scenario : Approval with Voucher
    Given I login with "AUTUser@flightmgmt.com" and "Merda2024!"
    When I create a new refund request
    And I select PNR "SB7476"
    Then i provide refunder email "tim.straatsma@pega.com"
    Then the case is sent for approval
   And i can log off
