package tests.day22_htmlReports_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C02_HardAssertions extends TestBaseCross {
    //1-amazon anasayfaya gidin
    //2-title in Amazon içerdigini test edin
    //3-arama kutusnun erişilebilir oldugunu tets edin
    //4-arama kutusuna Nuella yazıp aratın
    //5-arama yapıldıgını test edin
    //6-arama sonucunun Nutella içerdigini test edin


    @Test
    public void test01(){

        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2-title in Amazon içerdigini test edin
       Assert.assertTrue(driver.getTitle().contains("Amazon"));
        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());
        //4-arama kutusuna Nuella yazıp aratın
        searchBox.sendKeys("Nutella",Keys.ENTER);
        //5-arama yapıldıgını test edin

        WebElement sonucYaziWE =
                driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziWE.isDisplayed());
        //6-arama sonucunun Nutella içerdigini test edin
        Assert.assertTrue(sonucYaziWE.getText().contains("Nutella"));


    }
}
