@index-menus
Feature: The beverlyshill.solutions has an index page

@index-menusRest
Scenario: Accessing beverlyshill.solutions/index displays a web page with information about Beverly S. Hill
Given the page displays
Then menu items are found

@index-menusWeb
Scenario: Accessing http://beverlyshill.solutions/index displays a web page with a title of Beverly S. Hill
Given the web page displays
Then page title can be verified
