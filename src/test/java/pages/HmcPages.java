package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HmcPages {
    public HmcPages (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement login;

    @FindBy (xpath = "//*[@id='UserName']")
    public WebElement username;

    @FindBy (xpath = "//*[@id='Password']")
    public WebElement password;
}
