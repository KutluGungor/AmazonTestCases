import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FavoriteListPage extends BasePage{

    public FavoriteListPage(WebDriver driver)
    {
        super(driver);
    }

    private By favoriteListText = By.id("profile-list-name");
    private By deleteButton = By.cssSelector("input[name='submit.deleteItem']");
    private By deleteText = By.cssSelector(".a-box.a-alert-inline.a-alert-inline-success .a-box-inner.a-alert-container .a-alert-content");


    public String getFavoriteListText() {
       return driver.findElement(favoriteListText).getText();
    }

    public void clickDeleteButton()
    {
        waitElement(deleteButton);
        driver.findElement(deleteButton).click();
    }

    public String getDeleteText()
    {
        waitElement(deleteText);
        return driver.findElement(deleteText).getText();
    }

}
