/* Kutlu GÜNGÖR
    Software Test Engineer
    18.03.2022 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@ExtendWith(TestResultLogger.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SearchPage searchPage;
    ProductDetailPage productDetailPage;
    FavoriteListPage favoriteListPage;

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe" );
        this.driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        favoriteListPage = new FavoriteListPage(driver);
        driver.manage().window().maximize();

    }

    @AfterAll
    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

}
