package fr.zenity.appium.runner;

import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = "./src/test/resources/features",
            glue = {"fr.zenity.appium.steps"},
            monochrome = true,
            plugin = {
                    "pretty",
                    "html:target/reports/html/htmlreports",
                    "json:target/reports/jsonreports/index.json",
                    "junit:target/reports/xmlreport.xml",
            }
    )

    public class TestRunner extends BaseRunner{

}
