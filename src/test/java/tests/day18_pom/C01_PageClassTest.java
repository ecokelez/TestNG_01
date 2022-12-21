package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C01_PageClassTest {
     /*
       https://www.facebook.com/ adresine gidin
       POM’a uygun olarak email, sifre kutularini ve giris yap
       butonunu locate edin
       Faker class’ini kullanarak email ve sifre degerlerini
       yazdirip, giris butonuna basin
       Basarili giris yapilamadigini test edin
     */

    @Test
    public void test01(){
        //       https://www.facebook.com/ adresine gidin
        Driver.getDriver().get(" https://www.facebook.com/");
        //       cıkarsa Cookies'leri kabul edin
        //       POM’a uygun olarak email,sifre kutu. ve giris yap butonunu locate edin
        //       Faker class’ini kullanarak email ve sifre degerlerini
        //       yazdirip, giris butonuna basin
        FacebookPage facebookPage = new FacebookPage();
        Faker faker = new Faker();
        facebookPage.email.sendKeys(faker.internet().emailAddress());
        facebookPage.sifre.sendKeys(faker.internet().password());
        facebookPage.login.click();

        //       Basarili giris yapilamadigini test edin

        ///=> Assert.assertTrue(facebookPage.girisYapilamadi.isDisplayed());

        String actualText = null;
        try {
            actualText = facebookPage.girisYapilamadi.getText();
            Assert.assertFalse(actualText.contains("Facebook"));
        } catch (Exception e) {
            actualText = facebookPage.girisYapilamadiEvetBendim.getText();
            Assert.assertTrue(actualText.contains("Evet,Devam Et"));
        }


    }
}
