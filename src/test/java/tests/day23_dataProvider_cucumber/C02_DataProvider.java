package tests.day23_dataProvider_cucumber;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {

     /*
    https://www.bluerentalcars.com/ adresine git
    login butonuna bas
    Data provider ile 3 farklı userEmail ve 3 farklı password girelim
    login butonuna tiklayin
    Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
     */


    @DataProvider
    public static Object[][] kulanicilar() {
        return new Object[][]{{"ersoy@gmail.com", "12345"},{"cokelez@gmail.com", "2468"},{"ali@gmail.com", "0067"}};
    }
    @Test (dataProvider = "kulanicilar")
    public void test01(String userEmail, String password) {
        //    https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //    login butonuna bas
        BrcPage brcPage = new BrcPage();
        brcPage.ilkLogin.click();
        //    Data provider ile 3 farklı userEmail ve 3 farklı password girelim
        //    login butonuna tiklayin
        brcPage.email.sendKeys(userEmail);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(password).sendKeys(Keys.ENTER).perform();

        //    Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLogin.isDisplayed());
    }
}
