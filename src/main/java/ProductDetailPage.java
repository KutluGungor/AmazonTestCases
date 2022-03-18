import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    private By addMyListButton = By.id("add-to-wishlist-button-submit");
    private By checkProductAddedText = By.cssSelector(".a-size-medium-plus.huc-atwl-header-main");
    private By continueShoppingButton = By.cssSelector(".a-button-close.a-declarative");

    public void clickMyListButton()
    {
        waitElement(addMyListButton);
        driver.findElement(addMyListButton).click();
    }

    public String getCheckProductAddedText()
    {
        waitElement(checkProductAddedText);
        return driver.findElement(checkProductAddedText).getText();
    }

    public void clickContinueShoppingButton()
    {
        driver.findElement(continueShoppingButton).click();
    }



}
