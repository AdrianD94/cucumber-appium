Feature: Gyg Login Test
Scenario Outline: Login Test
  Given User is on login screen
  When User insert valid "<email>" and "<password>"
  And Click on Login button
  Then Users is redirected to the app home screen
Examples:
  | email   | password |
  | adytestare+828@gmail.com | test |
