package tests.day23_dataProvider_cucumber;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {


    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"java"},{"selenium"},{"samsung"},{"iphone"}};
    }

    @Test (dataProvider = "aranacakKelimeler")
    public void test01(String kelimeler) {
        AmazonPage amazonPage = new AmazonPage();
        //Amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        //Java,Selenium , Samsung ve iphone icin arama yapalım
        amazonPage.aramaKutusu.sendKeys(kelimeler,Keys.ENTER);
        //Sonuclarin aradıgımız kelimeleri icerdigini test edelim
        String actualSonuc = amazonPage.aramaSonucWE.getText();
        Assert.assertTrue(actualSonuc.contains(kelimeler));
        //Sayfayı kapatalim
        //Driver.closeDriver();

    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        Driver.closeDriver();
    }
}
