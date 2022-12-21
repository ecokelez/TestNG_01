package tests.day22_htmlReports_crossBrowser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_TestReport  extends TestBaseRapor {
         /*
    -https://www.bluerentalcars.com/ adresine git
    -login butonuna bas
    -test data user email: customer@bluerentalcars.com ,
    -test data password : 347040 dataları girip login e basın
    -login butonuna tiklayin
    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Test","Gecerli kullanıcı adı ve password ile giris yapıldı");
        //     -https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("BlueRentAlCar sitesine gidildi");
        //    -login butonuna bas
        BrcPage brcPage = new BrcPage();
        brcPage.ilkLogin.click();
        extentTest.info("Login butonuna basıldı");
        //    -test data user email: customer@bluerentalcars.com ,
        //    -test data password : 347040 dataları girip login e basın
        //    -login butonuna tiklayin
        brcPage.email.sendKeys(ConfigReader.getProperty("brcEmail"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("brcPassword")).sendKeys(Keys.TAB).
        sendKeys(Keys.ENTER).perform();
        extentTest.info("Dogru kullanici ve password ile girildi");
        extentTest.info("Ikinci login butonuna basildi");

        //    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String expectedUserName = "Yaman ARSLAN";
        String actualUserName = brcPage.profilIsim.getText();
        Assert.assertEquals(expectedUserName,actualUserName);
        extentTest.info("Sayfaya basarili bir sekilde giris yapıldı");


    }
}
