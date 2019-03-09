@index-menus
Feature: The beverlyshill.solutions has an index page

@index-menusRest
Scenario: Accessing beverlyshill.solutions/index displays a web page with information about Beverly S. Hill
Given the page displays
Then menu items are found

@index-titleWeb
Scenario: Accessing http://beverlyshill.solutions/index displays a web page with a title of Beverly S. Hill
Given the web page displays
Then page title can be verified

@index-menusWeb @index-menusHome
Scenario: Accessing http://beverlyshill.solutions/index displays the Beverly S. Hill menu
Given the web page displays
Then the Beverly S. Hill menu is found

@index-menusWeb @index-menusProExp
Scenario: Accessing http://beverlyshill.solutions/index displays the Professional Experience menu
Given the web page displays
Then the Professional Experience menu is found


