package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBaseCross {

    protected WebDriver driver;

    protected Actions actions ;
    protected String tarih;

    @Parameters("browser")
    @BeforeClass
    public  void setUp ( @Optional String browser ){

        driver = CrossDriver.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        actions = new Actions(driver);

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YY.MM.dd/HH.dd.mm");
        tarih = date.format(formatter);

    }

    @AfterClass
    public  void tearDown(){
        CrossDriver.closeDriver();
    }
}
