package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[@id='email'][1]")
    public WebElement email;

    @FindBy (xpath = "//*[@id='pass'][1]")
    public WebElement sifre;

    @FindBy (xpath = "//*[@name='login'][1]")
    public WebElement login;

    @FindBy (xpath = "//*[@class='_42ft _4jy0 _9kpt _4jy5 _4jy1 selected _51sy']")
    public WebElement girisYapilamadiEvetBendim;

    @FindBy (xpath = "//*[@class='_9ay7']")
    public WebElement girisYapilamadi;


}
