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
import pageobject.MainPage;
import pageobject.LoginPage;
import pageobject.RegistrationPage;
import service.Browser;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static service.Constants.*;


public class InputTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private ForgotPasswordPage forgotPasswordPage;
    protected String email;
    protected String password;
    protected String name;
    protected String accessToken;
    protected UserApi userApi;
    protected String expectedText;
    protected String actualText;


    @Before
    public void startActivity() throws IOException {

        driver = Browser.initDriver();
        driver.get(MAIN_PAGE_URL);
        mainPage = new MainPage(driver);

        email = "Leo" + RandomStringUtils.randomNumeric(5) + "@yandex.ru";
        password = "pass" + RandomStringUtils.randomNumeric(5);
        name = "User" + RandomStringUtils.randomNumeric(5);

        RestAssured.baseURI = MAIN_PAGE_URL;
        userApi = new UserApi();
        UserData userData = new UserData(email, password, name);
        Response response = userApi.createUser(userData);
        accessToken = response.body().as(ResponseUserData.class).getAccessToken();
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
        userApi.deleteUser(accessToken);
    }

    @Test
    @Description("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void loginAccountButtonTest() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mainPage.clickLoginAccountButton();
        driver.get(LOGIN_PAGE_URL);
        loginPage = new LoginPage(driver);
        loginPage.spellingField(email, password);
        expectedText = "Вход";
        actualText = loginPage.checkLoginPage();
        Assert.assertEquals(expectedText, actualText);
        loginPage.clickLoginButton();
        driver.get(MAIN_PAGE_URL);
        mainPage = new MainPage(driver);
        expectedText = "Соберите бургер";
        actualText = mainPage.checkMainPage();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    @Description("Вход по кнопке «Личный кабинет» на главной странице/Переход по клику на «Личный кабинет»")
    public void loginViaPersonalAccountTest() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mainPage.clickPersonalCabinetButton();
        driver.get(LOGIN_PAGE_URL);
        loginPage = new LoginPage(driver);
        loginPage.spellingField(email, password);
        expectedText = "Вход";
        actualText = loginPage.checkLoginPage();
        Assert.assertEquals(expectedText, actualText);
        loginPage.clickLoginButton();
        driver.get(MAIN_PAGE_URL);
        mainPage = new MainPage(driver);
        expectedText = "Соберите бургер";
        actualText = mainPage.checkMainPage();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    @Description("вход через кнопку в форме регистрации")
    public void loginViaRegistrationPageTest() {
        driver.get(REGISTRATION_PAGE_URL);
        registrationPage = new RegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        registrationPage.clickInputButton();
        driver.get(LOGIN_PAGE_URL);
        loginPage = new LoginPage(driver);
        loginPage.spellingField(email, password);
        expectedText = "Вход";
        actualText = loginPage.checkLoginPage();
        Assert.assertEquals(expectedText, actualText);
        loginPage.clickLoginButton();
        driver.get(MAIN_PAGE_URL);
        mainPage = new MainPage(driver);
        expectedText = "Соберите бургер";
        actualText = mainPage.checkMainPage();
        Assert.assertEquals(expectedText, actualText);

    }


    @Test
    @Description("вход через кнопку в форме восстановления пароля")
    public void loginViaForgotPasswordPageTest() {
        driver.get(FORGOT_PASSWORD_URL);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        forgotPasswordPage.clickInputButton();
        driver.get(LOGIN_PAGE_URL);
        loginPage = new LoginPage(driver);
        loginPage.spellingField(email, password);
        expectedText = "Вход";
        actualText = loginPage.checkLoginPage();
        Assert.assertEquals(expectedText, actualText);
        loginPage.clickLoginButton();
        driver.get(MAIN_PAGE_URL);
        mainPage = new MainPage(driver);
        expectedText = "Соберите бургер";
        actualText = mainPage.checkMainPage();
        Assert.assertEquals(expectedText, actualText);

    }
}
