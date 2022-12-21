package tests.day19_testNG_pom;

import org.testng.annotations.Test;

public class C01_SingletonPattern {


    @Test
    public void test01() {
        //Driver obj = new Driver();
        //obj.getDriver().get(ConfigReader.getProperty("amznUrl"));

        //==>  SingletonPattern : tekli kullanım demektir. Bir class'ın farklı class'lardan
        // obje oluşturarak kullanımını engellemektir.

        //==> Bunu saglamak iicn yapmamiz gereken sey obj. olusturmak icin kullanilan
        //==> constructor'ı private yaptıgınızda baska class'larda Driver class'ından
        //==> obj. olusturulması mumkun olamaz

    }
}
