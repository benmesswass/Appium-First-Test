package fr.zenity.appium.PageObjects;

import fr.zenity.appium.drivers.LocalDriver;
import fr.zenity.appium.manager.MobileDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public abstract class Page {
    /***
     * Driver
     */
    protected AppiumDriver<MobileElement> driver;
    /**
     * Waiter
     * */
    protected WebDriverWait wait;
    protected WebDriverWait shortWait;
    protected WebDriverWait middleWait;
    protected WebDriverWait longWait;
    /**
     * JS
     * */
    protected JavascriptExecutor js;
    /***
     * Actions
     */
    protected Actions action;

    /**
     * logger
     */
    private static final Logger LOG = Logger.getLogger(Page.class);

    protected Page(){

        driver = (AppiumDriver<MobileElement>) MobileDriverManager.getInstance().getDriver();

         PageFactory.initElements((WebDriver) driver,this);

        wait        = new WebDriverWait(new LocalDriver().getDriver(), 5);
        shortWait   = new WebDriverWait((WebDriver) driver, 10);
        middleWait  = new WebDriverWait((WebDriver) driver, 15);
        longWait    = new WebDriverWait((WebDriver) driver, 30);

        js          = (JavascriptExecutor)driver;
        action      = new Actions((WebDriver) driver);

    }

    public <V> boolean waitUntil(Function<? super WebDriver, V> isTrue){
        try {
            wait.until(isTrue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public <V> boolean shortWaitUntil(Function<? super WebDriver, V> isTrue){
        try {
            shortWait.until(isTrue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public <V> boolean middleWaitUntil(Function<? super WebDriver, V> isTrue){
        try {
            shortWait.until(isTrue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public <V> boolean longWaitUntil(Function<? super WebDriver, V> isTrue){
        try {
            shortWait.until(isTrue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
