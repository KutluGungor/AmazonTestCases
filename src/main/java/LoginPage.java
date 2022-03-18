import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public By inputEmail = By.id("ap_email");
    public By continueButton = By.id("continue");
    public By inputPassword = By.id("ap_password");
    public By loginButton = By.id("signInSubmit");
    public By loginText = By.cssSelector(".a-box-inner.a-padding-extra-large .a-spacing-small");


    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public void setLoginEmail(String emailText) {
        WebElement emailInput = driver.findElement(inputEmail);
        emailInput.click();
        emailInput.sendKeys(emailText);
    }
    public void clickContinueButton(){
        WebElement clickContinue = driver.findElement(continueButton);
        clickContinue.click();
    }

    public void setPassword(String password){
        WebElement passwordInput = driver.findElement(inputPassword);
        passwordInput.click();
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton()
    {
        driver.findElement(loginButton).click();
    }

    public String getLoginText(){
        return driver.findElement(loginText).getText();
    }
}
