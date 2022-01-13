package fr.zenity.appium.manager;

import fr.zenity.appium.drivers.DriversImpl;
import fr.zenity.appium.drivers.LocalDriver;
import io.appium.java_client.AppiumDriver;

public class MobileDriverManager implements DriversImpl {

    private final static MobileDriverManager INSTANCE = new MobileDriverManager();

    private ThreadLocal<LocalDriver> driver = new ThreadLocal<>();

    protected MobileDriverManager(){ }

    @Override
    public void close() {
        driver.get().close();
    }

    @Override
    public void quit() {
         driver.get().quit();
    }

    @Override
    public AppiumDriver<?> getDriver() {
        return driver.get().getDriver();
    }

    public void setDriver(){
        driver.set(new LocalDriver());
    }

    public static MobileDriverManager getInstance(){ return INSTANCE; }
}
