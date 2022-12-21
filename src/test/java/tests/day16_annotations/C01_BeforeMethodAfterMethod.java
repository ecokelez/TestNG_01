package tests.day16_annotations;

import org.testng.annotations.Test;
import utilities.TestBase_BeforeMethodAfterMethod;

public class C01_BeforeMethodAfterMethod extends TestBase_BeforeMethodAfterMethod {
    @Test
    public void amazonTesti01(){
      driver.get("https://amazon.com");
    }

    @Test (groups = "grup1")
    public void bestBuyTesti01(){
        driver.get("https://bestBuy.com");
    }

    @Test
    public void techproeducationTesti01(){
        driver.get("https://techproeducation.com");
    }

}
