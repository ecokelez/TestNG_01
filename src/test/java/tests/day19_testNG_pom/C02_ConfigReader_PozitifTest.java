package tests.day19_testNG_pom;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReader_PozitifTest {
    /*
    https://www.bluerentalcars.com/ adresine git
    login butonuna bas
    test data user email : customer@bluerentalcars.com
    test data paswword : 12345
    dgerler girildiginde syfaya basarili bir sekide girebildigini test et
     */


    @Test
    public void pozitifLoginTest() {
        //    https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //    login butonuna bas
        // ==>  test data user email : customer@bluerentalcars.com
        //==>  test data paswword : customer@bluerentalcars.com
        BrcPage brcPage = new BrcPage();
        brcPage.ilkLogin.click();
        brcPage.email.sendKeys(ConfigReader.getProperty("brcEmail"));
        brcPage.password.sendKeys(ConfigReader.getProperty("brcPassword"));
        brcPage.ikinciLogin.click();

        //    dgerler girildiginde syfaya basarili bir sekide girebildigini test et
        System.out.println(brcPage.profilIsim.getText());
        String expectedUserName = ConfigReader.getProperty("brcValidUsername");
        String actualUserName = brcPage.profilIsim.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedUserName,actualUserName);



    }
}
