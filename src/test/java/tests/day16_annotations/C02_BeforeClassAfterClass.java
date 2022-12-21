package tests.day16_annotations;

import org.testng.annotations.Test;
import utilities.TestBase_BeforeClassAfterClass;

public class C02_BeforeClassAfterClass extends TestBase_BeforeClassAfterClass {

    @Test
    public void testAmazon() {
        driver.get("https://amazon.com");
    }

    @Test
    public void testBestBuy() {
        driver.get("https://bestbuy.com");
    }

    @Test
    public void testTechproeducation() {
        driver.get("https://techproeducation.com");
    }
}
