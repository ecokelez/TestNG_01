package tests.day23_dataProvider_cucumber;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.ReusableMethods.waitFor;

public class C02_DataProviderRECAP{
    @DataProvider
    public static Object[][] kullanicilar() {
        return new Object[][]{{"ersoy@gmail.com","123"},{"cokelez@gmail.com", "2468"},{"rafet_ali@gmail.com","357"}};
    }

        /*
    https://www.bluerentalcars.com/ adresine git
    login butonuna bas
    Data provider ile 3 farklı userEmail ve 3 farklı password girelim
    login butonuna tiklayin
    Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
     */
    
    

    @Test (dataProvider = "kullanicilar")
    public void test01(String userEmail,String password) {
        //    https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        waitFor(3);
        //    login butonuna bas
        BrcPage brcPage = new BrcPage();
        brcPage.ilkLogin.click();
        //    Data provider ile 3 farklı userEmail ve 3 farklı password girelim
        //    login butonuna tiklayin
        brcPage.email.sendKeys(userEmail);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(password).
                sendKeys(Keys.ENTER).perform();
        //    Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLogin.isDisplayed());


    }
}
