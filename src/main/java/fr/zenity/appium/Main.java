package fr.zenity.appium;

import fr.zenity.appium.config.ApplicationProperties;
import fr.zenity.appium.config.PropertiesLoader;
import fr.zenity.appium.drivers.LocalDriver;
import fr.zenity.appium.server.AppiumServer;

import static java.lang.Thread.*;

public class Main {

    public static void main (String[] args){

        ApplicationProperties applicationProperties = ApplicationProperties.getInstance();

        System.out.println(
                applicationProperties.getAndroidApplicationPath()
                +"/ "+applicationProperties.getAppiumServerHost()
                +"/ "+applicationProperties.getAppiumServerPort()
                +"/ "+applicationProperties.getProxy()
        );

        AppiumServer.start();

        try {
            new LocalDriver();
            Thread.sleep(15000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        AppiumServer.stop();
    }
}
