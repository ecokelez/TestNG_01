package tests.day18_pom;

import org.testng.annotations.Test;
import pages.HmcPages;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_ConfigReader {
    /*
    Bir test method olustur positiveLoginTest()
    https://www.hotelmycamp.com adresine git login butonuna bas
    test data username: manager , test data password :Manager1!
    Degerleri girildiginde sayfaya basarili sekilde girilebildigini testet
     */

    @Test  (groups = "grup2")
    public void test01(){
        //    https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        //    lgin butonuna bas
        //    test data username: manager , test data password :Manager1!
        HmcPages hmcPages = new HmcPages();
        hmcPages.username.sendKeys(ConfigReader.getProperty("hmcUsername"));
        hmcPages.password.sendKeys(ConfigReader.getProperty("hmcPassword"));

        //    Degerleri girildiginde sayfaya basarili sekilde girilebildigini testet

    }
}
