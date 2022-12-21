package tests.day18_pom;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigurationProperties {
    @Test
    public void test01(){
        //Amazon sayfasına ve facebook sayfasına gidiniz
        String urlAmazon = ConfigReader.getProperty("amznUrl");
        Driver.getDriver().get(urlAmazon);
        String urlFace = ConfigReader.getProperty("faceUrl");
        Driver.getDriver().get(urlFace);
        Driver.closeDriver();
    }
}
