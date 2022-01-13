package fr.zenity.appium.runner;

import fr.zenity.appium.drivers.LocalDriver;
import fr.zenity.appium.server.AppiumServer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class BaseRunner extends AbstractTestNGCucumberTests {


    @BeforeTest
    public void setup() throws MalformedURLException {
        AppiumServer.start();
        new LocalDriver();
    }


    @AfterTest
    public void teardown(){
        AppiumServer.stop();
    }

}
