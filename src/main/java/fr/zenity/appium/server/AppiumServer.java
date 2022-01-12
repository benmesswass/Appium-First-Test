package fr.zenity.appium.server;

import fr.zenity.appium.config.Properties;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.ServerSocket;

public class AppiumServer {

    //private static Logger LOG = LoggerFactory.log4j.Logger;
    private static AppiumDriverLocalService localDaemon;
/*
    DesiredCapabilities cap = new DesiredCapabilities();
    cap.setCapability("noReset", "false");

 */

    public static void start(){
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withIPAddress(Properties.appConfig.getAppiumServerHost())
                .usingPort(Properties.appConfig.getAppiumServerPort())
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.RELAXED_SECURITY)
                        .usingDriverExecutable((new File("C:\\Program Files\\nodejs\\node.exe")));

        AppiumDriverLocalService.buildService(serviceBuilder);

        localDaemon = AppiumDriverLocalService.buildService(serviceBuilder);
        localDaemon.start();
        System.out.println("---------------Starting Appium Server----------------");
    }

    public static void stop(){
        try{localDaemon.stop();
            System.out.println("---------------Appium Server has been stopped----------------");
        }
        catch (Exception e){
            System.out.println("---------------Stopping Appium Server----------------");
        }
    }

    public static boolean isRunning(){
        try{
        new ServerSocket(Properties.appConfig.getAppiumServerPort()).close();
        }
        catch(Exception e){
            return true;
        }

        return false;
    }
}
