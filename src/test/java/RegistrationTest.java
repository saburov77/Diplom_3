import api.ResponseUserData;
import api.UserApi;
import api.UserData;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import pageobject.RegistrationPage;
import service.Browser;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static service.Constants.*;

public class RegistrationTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    protected String email;
    protected String password;
    protected String name;
    protected String accessToken;
    protected UserApi userApi;

    @Before
    public void startActivity() throws IOException {
        RestAssured.baseURI = MAIN_PAGE_URL;
        userApi = new UserApi();
        driver = Browser.initDriver();
        driver.get(REGISTRATION_PAGE_URL);
        registrationPage = new RegistrationPage(driver);
        email = "Leo" + RandomStringUtils.randomNumeric(3) + "@yandex.ru";
        password = "pass" + RandomStringUtils.randomNumeric(6);
        name = "User" + RandomStringUtils.randomNumeric(4);
    }

   @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }

    @Test
    @Description("Проверка успешной регистрации")
    public void successfulRegistrationTest() {
        registrationPage.spellingField(name, email, password);
        registrationPage.clickRegisterButton();
        driver.get(LOGIN_PAGE_URL);
        loginPage = new LoginPage(driver);
        String expectedText = "Вход";
        String actualText = loginPage.checkLoginPage();
        Assert.assertEquals(expectedText, actualText);


        UserData userData = new UserData(email, password);
        Response response = userApi.loginUser(userData);
        accessToken = response.body().as(ResponseUserData.class).getAccessToken();
        userApi.deleteUser(accessToken);
    }

    @Test
    @Description("Проверка ошибки для некорректного пароля. Минимальный пароль — шесть символов.")
    public void incorrectPasswordEntryTest() {
        registrationPage.spellingField(name, email, "12345");
        registrationPage.clickRegisterButton();
        String expectedText = "Некорректный пароль";
        String actualText = registrationPage.getErrorText();
        Assert.assertEquals(expectedText, actualText);
    }
}

