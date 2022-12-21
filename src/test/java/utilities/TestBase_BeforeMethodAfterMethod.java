package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase_BeforeMethodAfterMethod {

   protected WebDriver driver;
   protected Actions actions;
   protected String tarih;

    // TestNG framework'unde @Before ve @After notasyonları yerine @BeforeMethod ve @AfterMethod kullanılır
    // Çalışma prensibi  JUnit' deki Before,After ile aynıdır

    @BeforeMethod (groups = "grup1")
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YY.MM.dd/HH.dd.mm");
        tarih = date.format(formatter);

    }

    @AfterMethod (groups = "grup1")
    public void tearDown(){

        driver.close();
    }
}
