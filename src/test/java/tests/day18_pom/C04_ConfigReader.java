package tests.day18_pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_ConfigReader {

     /*
       https://www.facebook.com/ adresine gidin
       Cıkarsa cookies kabul edin
       Kullanici mail kutusna yanlis  kullanici ismi yazdirin
       Kullanici sifre kutusna yanlis  passord yazdirin
       giris butonuna basin
       Basarili giris yapilamadigini test edin
       Sayfayi kapatin
     */

    @Test (groups = "grup2")
    public void test01() {
        //       https://www.facebook.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("faceUrl"));
        //       Cıkarsa cookies kabul edin
        //       Kullanici mail kutusna yanlis  kullanici ismi yazdirin
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.email.sendKeys(ConfigReader.getProperty("fbWrongEmail"));
        //       Kullanici sifre kutusna yanlis  passord yazdirin
        facebookPage.sifre.sendKeys(ConfigReader.getProperty("fbWrongPassword"));
        //       giris butonuna basin
        facebookPage.login.click();
        //       Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girisYapilamadi.isDisplayed());
        //       Sayfayi kapatin
        Driver.closeDriver();

    }
}
