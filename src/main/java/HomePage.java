import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public By cookiesId = By.id("sp-cc-accept");
    public By firstLoginButton = By.id("nav-link-accountList");
    public By userNameSpan = By.id("nav-link-accountList-nav-line-1");
    public By selectDropdown = By.id("searchDropdownBox");
    public By searchInput = By.id("twotabsearchtextbox");
    public By searchButton = By.id("nav-search-submit-button");
    public By hoverMenu = By.id("nav-link-accountList");
    public By favoriteListButton = By.cssSelector("a[href=\"/hz/wishlist/ls/JTPKT7869CXG/ref=nav_wishlist_lists_1\"");
    public By logoutButton = By.id("nav-item-signout");

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }

    public void clickCookiesButton()
    {
        WebElement button = driver.findElement(cookiesId);
        button.click();
    }

    public boolean getCookiesId()
    {
        try {
            driver.findElement(cookiesId);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void clickFirstLoginButton()
    {
        WebElement clickFirstLoginButton = driver.findElement(firstLoginButton);
        clickFirstLoginButton.click();
    }

    public String getUserNameSpanText()
    {
        return driver.findElement(userNameSpan).getText();
    }

    public void selectCategoryDropdown(){
        Select dropdown = new Select(driver.findElement(selectDropdown));
        dropdown.selectByValue("search-alias=computers");
    }

    public String getSelectDropdownValue()
    {
        Select dropdown = new Select(driver.findElement(selectDropdown));
        return dropdown.getFirstSelectedOption().getText();
    }
    public void setSearchInput(String search)
    {
        WebElement passwordInput = driver.findElement(searchInput);
        passwordInput.click();
        passwordInput.sendKeys(search);
    }

    public void clickSearchButton()
    {
        WebElement button = driver.findElement(searchButton);
        button.click();
    }

   public void hoverMenu(){

       waitElement(hoverMenu);
       Actions action = new Actions(driver);
       WebElement elem = driver.findElement(hoverMenu);
       action.moveToElement(elem);
       action.perform();
       sleep(3);
   }

    public void clickFavoriteList()
    {
        waitElement(favoriteListButton);
        driver.findElement(favoriteListButton).click();
    }

    public void clickLogoutButton(){
        waitElement(logoutButton);
        driver.findElement(logoutButton).click();
    }

    public void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }
}
