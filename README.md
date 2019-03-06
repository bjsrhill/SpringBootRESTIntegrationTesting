Example integration testing of the REST endpoints of a web application. Uses Cucumber JVM and Spring Boot RestTemplate for testing a website's REST API and Selenium for testing the web page elements.

The Selenium chromedriver used is a macOS driver.

All of the tests can be executed with the following Maven command:

clean verify -PintegrationTesting -Dcucumber.options='--tags @index-menus --tags ~@WIP'

The REST test can be run with the following Maven command:

clean verify -PintegrationTesting -Dcucumber.options='--tags @index-menusRest --tags ~@WIP'

The Selenium test can be run with the following Maven command:

clean verify -PintegrationTesting -Dcucumber.options='--tags @index-menusWeb --tags ~@WIP'