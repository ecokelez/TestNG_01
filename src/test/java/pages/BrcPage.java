package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BrcPage {

    public BrcPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//*[@class='btn btn-primary btn-sm']")
    public WebElement ilkLogin;

    @FindBy (xpath = "//*[@id='formBasicEmail']")
    public WebElement email;

    @FindBy (xpath = "//*[@id='formBasicPassword']")
    public WebElement password;


    @FindBy (xpath = "//*[@class='btn btn-primary'][1]")
    public WebElement ikinciLogin;

    @FindBy (id = "dropdown-basic-button")
    public WebElement profilIsim;

    @FindBy (xpath = "//*[@class='Toastify__toast-body']")
    public WebElement girisYapilamadi;




}
