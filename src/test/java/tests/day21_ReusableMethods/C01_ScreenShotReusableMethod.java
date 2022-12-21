package tests.day21_ReusableMethods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import tests.day24_log4J.Log4JTest2_CokSukur;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {

    private static Logger logger = LogManager.getLogger(C01_ScreenShotReusableMethod.class.getName());

    @Test
    public void test01() throws IOException {

        logger.info("Hepsiburada.com' a gidilir");
        //hepsiburada.com' a gidiniz
        Driver.getDriver().get("https://hepsiburada.com");
        //Sayfanın resmini alınz
        logger.info("Sayfanın ekran resmi alinir");
        ReusableMethods.getScreenshot("hepsiburada");
        //Sayfayı kapatınız
        logger.warn("Driver kapatilir");
        Driver.closeDriver();

    }



    @Test
    public void test02() throws IOException {
        //Amazon sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        //Nutella aratınız
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella",Keys.ENTER);
        //Arama sonuc yazısı Webelementinin resmini alınız
        ReusableMethods.getScreenshotWebElement("AramaSonucWE",amazonPage.aramaSonucWE);

    }
}
