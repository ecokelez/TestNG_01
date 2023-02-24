package tests.day16_annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase_BeforeClassAfterClass;

public class C04_DependsOnMethods extends TestBase_BeforeClassAfterClass {

    @Test
    public void test01() {
        //amazon ana sayfasına gidelim
        driver.get("https://amazon.com");
    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        //Nutella aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
    }

    @Test (dependsOnMethods = "test02")
    public void test03() {
        //Sonuc yazısının amazon icerdigini test edin
        WebElement aramaSonuc= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertFalse(aramaSonuc.getText().contains("amazon"));

        //==> Farklı bir test yontemi !!! ONEMLI 
        assert!driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"))
                .getText().contains("amazon");
    }
}
