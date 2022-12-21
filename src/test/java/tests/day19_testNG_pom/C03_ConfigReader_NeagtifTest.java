package tests.day19_testNG_pom;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_ConfigReader_NeagtifTest {
     /*
    https://www.bluerentalcars.com/ adresine git
    login butonuna bas
    test data user email : boss@bluerentalcars.com
    test data paswword : 12345
    dgerler girildiginde syfaya basarili bir sekide girelemedigini test et
     */

    @Test
    public void negatifTest() {
        //    https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //    login butonuna bas
        //    test data user email : boss@bluerentalcars.com
        //    test data paswword : 12345
        BrcPage brcPage = new BrcPage();
        brcPage.ilkLogin.click();
        brcPage.email.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        brcPage.password.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        brcPage.ikinciLogin.click();
        //    dgerler girildiginde syfaya basarili bir sekide girelemedigini test et
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(brcPage.girisYapilamadi.isDisplayed());
    }

}
