import api.ResponseUserData;
import api.UserApi;
import api.UserData;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.ForgotPasswordPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import service.Browser;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static service.Constants.LOGIN_PAGE_URL;
import static service.Constants.MAIN_PAGE_URL;

public class TransferTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    protected String expectedText;
    protected String actualText;


    @Before
    public void startActivity() throws IOException {
        driver = Browser.initDriver();
        driver.get(LOGIN_PAGE_URL);
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }

    @Test
    @Description("Переход на главную страницу по клику на кнопку Конструктор")
    public void clickOnTheConstructorButtonTest() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.clickConstructor();
        driver.get(MAIN_PAGE_URL);
        mainPage = new MainPage(driver);
        expectedText = "Соберите бургер";
        actualText = mainPage.checkMainPage();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    @Description("Переход на главную страницу по клику на ЛОГО")
    public void clickOnLogoButtonTest() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.clickLogo();
        driver.get(MAIN_PAGE_URL);
        mainPage = new MainPage(driver);
        expectedText = "Соберите бургер";
        actualText = mainPage.checkMainPage();
        Assert.assertEquals(expectedText, actualText);
    }
}
