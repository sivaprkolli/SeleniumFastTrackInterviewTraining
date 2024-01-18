package Misc;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;

public class ReadDataFromConfig{

    @Test
    public void read(){
        MobileConfig mc = ConfigFactory.create(MobileConfig.class);
        System.out.println("Server ::" + mc.serverIp());
        System.out.println("Post number :: " + mc.portNumber());
        System.out.println("Local :: " + mc.runLocal());

         }
}
