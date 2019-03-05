package com.beverlyshill.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", strict = true, glue = "com.beverlyshill.steps", plugin = {"pretty", "json:target/cucumber.json"}, tags = {"~@WIP"})
public class BeverlyshillRESTIntegrationTestingRunner {

}
