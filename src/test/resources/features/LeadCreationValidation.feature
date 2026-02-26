Feature: LeadCreation Functionality

  As a sales representative
  I want to create a new lead in the CRM system
  So that I can track potential customers and follow up with them

  Background:
    Given User is on the Lead Creation Page

  # ---------------- POSITIVE SCENARIO ----------------

  @PositiveLeadCreation
  Scenario: Successful lead creation with valid details
    When User enters valid username "admin" password "root" and logs in
    When User enters valid lead details from excel "Lead_01"
    And User clicks on Save button
    Then Lead should be created successfully
    And Confirmation message "Lead created successfully" should be displayed

