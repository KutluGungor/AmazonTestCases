import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{

    private By searchText = By.cssSelector(".a-color-state.a-text-bold");
    private By pageButton = By.cssSelector(".s-pagination-item.s-pagination-button");
    private By selectedPage = By.cssSelector(".s-pagination-item.s-pagination-selected");

    private By secondProduct = By.cssSelector("[data-index=\"2\"]");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String searchString()
    {
        WebElement searchString = driver.findElement(searchText);
        return searchString.getText();
    }

    public void clickPageButton()
    {
        driver.findElement(pageButton).click();
    }

    public String getSelectedPage()
    {
        waitElement(selectedPage);
        WebElement searchString = driver.findElement(selectedPage);
        return searchString.getText();
    }

    public void clickSecondProduct()
    {
        waitElement(secondProduct);
        driver.findElement(secondProduct).click();
    }


}
