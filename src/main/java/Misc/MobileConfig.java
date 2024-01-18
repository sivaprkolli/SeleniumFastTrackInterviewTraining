package Misc;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("file:MobileConfig.properties")
public interface MobileConfig extends Config{

    @Key("appium.run.local")
    @DefaultValue("false")
    boolean runLocal();

    @Key("appium.server.ip")
    @DefaultValue("${appium.server.ip}")
    String serverIp();

    @Key("appium.server.port")
    @DefaultValue("${appium.server.port}")
    String portNumber();
}
