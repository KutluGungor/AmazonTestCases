import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestHomePage extends BaseTest {


    @Test
    @Order(1)
    public void checkBasePageUrl(){
        Assertions.assertEquals("https://www.amazon.com.tr/", homePage.getUrl(), "Homepage is not Correct");
    }

    @Test
    @Order(2)
    public void acceptCookiesAndCheck(){
        homePage.clickCookiesButton();
        Assertions.assertFalse(homePage.getCookiesId(),"Element found");
    }

    @Test
    @Order(3)
    public void checkLoginWhenLoginSuccesful()
    {
        homePage.clickFirstLoginButton();
        loginPage.setLoginEmail("kutlugungor58@hotmail.com");
        loginPage.clickContinueButton();
        loginPage.setPassword("kutlu.gungor.199");
        loginPage.clickLoginButton();
        Assertions.assertEquals("Kutlu", homePage.getUserNameSpanText(), "Login failed");
    }

    @Test
    @Order(4)
    public void checkDropDownWhenSelectComputers()
    {
        homePage.selectCategoryDropdown();
        Assertions.assertEquals("Bilgisayarlar", homePage.getSelectDropdownValue(), "Category is not correct");

    }

    @Test
    @Order(5)
    public void checkSearchForMsi()
    {
        homePage.setSearchInput("msi");
        homePage.clickSearchButton();
        Assertions.assertEquals("\"msi\"", searchPage.searchString(), "Search failed");

    }

    @Test
    @Order(6)
    public void checkSecondPage()
    {
        searchPage.clickPageButton();
        Assertions.assertEquals("2", searchPage.getSelectedPage(), "The selected page is not number 2");
    }

    @Test
    @Order(7)
    public void checkFavoriteList()
    {
        searchPage.clickSecondProduct();
        productDetailPage.clickMyListButton();
        Assertions.assertEquals("1 ürün şuraya eklendi:", productDetailPage.getCheckProductAddedText(),"The product could not be added to the list");
    }

    @Test
    @Order(8)
    public void checkOpenFavoriteList()
    {
        productDetailPage.clickContinueShoppingButton();
        homePage.hoverMenu();
        homePage.clickFavoriteList();
        Assertions.assertEquals("Alışveriş Listesi", favoriteListPage.getFavoriteListText(),"You are not on the favorite list");

    }

    @Test
    @Order(9)
    public void checkRemoveFromFavoriteList()
    {
        favoriteListPage.clickDeleteButton();
        Assertions.assertEquals("Silindi", favoriteListPage.getDeleteText(),"The product could not be deleted");

    }

    @Test
    @Order(10)
    public void checkLogout()
    {
        homePage.hoverMenu();
        homePage.clickLogoutButton();
        Assertions.assertEquals("Giriş yap", loginPage.getLoginText(),"Exit Failed" );
    }



}
