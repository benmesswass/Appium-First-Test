package fr.zenity.appium.config;

import fr.zenity.appium.Enum.Device;
import fr.zenity.appium.Enum.Platform;

public class PropertiesConfig {

    private static PropertiesConfig INSTANCE = new PropertiesConfig();

    private PropertiesLoader prop = PropertiesLoader.of("configuration");

    private static Device device;
    private static Platform mos;

    public PropertiesConfig(){
        String tmp;

        //tmp = System.getProperty("overrideDevice", prop.getProperty("overrideDevice"));
        // if(!Objects.isNull(tmp)){
        //    device = Device.parse("custom"+tmp);
        //}else {
        tmp = System.getProperty("device", prop.getProperty("device", "samsumg"));
        device = Device.parse(tmp.toUpperCase());
        // }

        System.out.println("Devince "+ device.getName()+" "+ device.toString());
        tmp     = System.getProperty("mos", prop.getProperty("mos","android"));
        mos     = Platform.valueOf(tmp.toUpperCase());

    }

    public static Device getDevice(){ return device; }

    public static Platform getMobileOS(){ return mos; }

    public static PropertiesConfig getInstance(){ return INSTANCE; }

}
