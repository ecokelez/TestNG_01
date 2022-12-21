package tests.day16_annotations;

import org.testng.annotations.Test;
import utilities.TestBase_BeforeMethodAfterMethod;

public class C03_Priority extends TestBase_BeforeMethodAfterMethod {

    /*
      TestNG (default) olarak @Test methodlarıni alfabetik sıraya göre run eder. (Yukardan asagi degil!)
      ==> Priority annotation Testlere öncelik vermek için kullanılır.
      ==> Kucuk olan numara daha once calisir ,
      ==> priority yazmayan test method'u varsa oncelikle o calisir,
      ==> sonra priority yazan testler siralanir
      ==> Priority kullanmazsak default olarak 0 dır
     */

    @Test (priority = -1)
    public void youTubeTest() {
        driver.get("https://youtube.com");
    }

    @Test
    public void bestBuyTest() {
        driver.get("https://bestbuy.com");
    }

    @Test (priority = 2)
    public void amazonTest() {
        driver.get("https://amazon.com");
    }

    @Test (priority = -1 , groups = "grup1")
    public void hepsiBuradaTest() {
        driver.get("https://hepsiburada.com");
    }
}
