package tests.day17_softAssert_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C03_DriverFirstTest {


    // TestBase class'ina extend ederek kullandigimiz driver yerine artik
    // Driver class'indan kullanacagimiz getDriver() static methodunu kullaniriz

    @Test
    public void test01(){
        Driver.getDriver().get("https://amazon.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://bestbuy.com");
        Driver.getDriver().get("https://hepsiburada.com");
        Driver.closeDriver();
    }
}
