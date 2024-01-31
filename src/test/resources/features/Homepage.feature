Feature: Sample Homepage Automation

@TestLogin
Scenario Outline: Validate whether user can login to the book store  application
  Given User provide <Username> and <Password> in "login" page
  When User clicks the login button
  Then User should be take to the store
  Examples:
    |Username  | Password|
    |"Susie"    |"Test@123" |



 @TestForm
 Scenario: Validate whether user can fill the details in the form
   Given User launches the "text-box" form
   When User provides the details
   And click submit
   Then the details should be saved

 @TestCheckBox
 Scenario: Validate whether user can select the checkboxes
   Given User launches the "checkbox" form
   When I expand the list
   Then I enable the check boxes

@TestRadioChecBox
Scenario: Validate whether user select the radio button
  Given User launches the "radio-button" form
  When I select the "Impressive" radio button
  Then Selected option should be displayed

  @Testclick
  Scenario: Validate whether user select the click button
    Given User launches the "buttons" form
    When I double click the double click button
    And I right click the right click button
    Then corresponding message should be displayed

  @TestLinks
  Scenario: Validate whether user select the click button
    Given User launches the "broken" form
    When User clicks "ValidLink" Link, HomePage should be launched

  @TestUpload
  Scenario: Validate whether user xselect the click button
    Given User launches the "upload-download" form
    When User clicks click upload file to upload a new file
