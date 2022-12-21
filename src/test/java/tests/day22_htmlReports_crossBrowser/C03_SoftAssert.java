package tests.day22_htmlReports_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseCross;

public class C03_SoftAssert extends TestBaseCross {


        /*
      SoftAssert baslangic ve bitis satirlari arasindaki tum assertion'lari yapip
      bitis olarak belirtmemiz gereken assertAll() methoduyla test methodumuzdaki
      butun assertion'lari kontrol eder. Failed olan olursa assertion yaptigimiz
      methodun sonuna yazdigimiz mesaji bize konsolda verir.
      ==> assertAll()'da failed rapor edilirse calisma durur,class'ın kalan kısmı calıstırlmaz
      */

    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();

        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");
        //2-title in Amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"),"Girdiginiz kelimeyi icermiyor");
        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchBox.isEnabled(),"WE erisilemez");
        //4-arama kutusuna Nuella yazıp aratın
        searchBox.sendKeys("Nutella", Keys.ENTER);
        //5-arama yapıldıgını test edin
        WebElement sonuc = driver.findElement
                (By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonuc.isDisplayed(),"Sonuc WE goruntulenemedi");
        //6-arama sonucunun Nutella içerdigini test edin
        softAssert.assertTrue(sonuc.getText().contains("Nutella"),"Nutella icermiyor");
        softAssert.assertAll();
        System.out.println("Hata varsa burası calismaz");


        }


}
