package fr.zenity.appium.manager;

import fr.zenity.appium.Enum.Device;
import fr.zenity.appium.Enum.Platform;
import fr.zenity.appium.drivers.AndroidConnector;
import fr.zenity.appium.drivers.DriversImpl;
import fr.zenity.appium.drivers.LocalDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.slf4j.Logger;

import java.util.Locale;

public class MobileDriverManager {

    private final static MobileDriverManager INSTANCE = new MobileDriverManager();

    //private static Logger LOG = Logger.getLogger(MobileDriverManager.class);

    private ThreadLocal<DriversImpl> driver = new ThreadLocal<>();

    protected MobileDriverManager(){ }

    public DriversImpl getDriver(){return driver.get(); }


    public void setDriver(Device device, Platform platform) {
        //
        //LOG.info("Platform selected :" + platform.toString().toUpperCase(Locale.ROOT));
        //LOG.info("Device selected :" + device.getName());
        switch (platform) {
            case ANDROID:
                driver.set(new AndroidConnector(device, platform));
                break;
            case WINDOWS_PHONE:
            case IOS:
            default:
                throw new UnsupportedOperationException(String.format("Mobile Platform '%s' not supported", platform));
        }
    }

        public static MobileDriverManager getInstance(){ return INSTANCE; }
}
