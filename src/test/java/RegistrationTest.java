import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import pageobject.RegistrationPage;
import service.Browser;

import java.io.IOException;

import static service.Constants.LOGIN_PAGE_URL;
import static service.Constants.REGISTRATION_PAGE_URL;

public class RegistrationTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    protected String email;
    protected String password;
    protected String name;

    @Before
    public void startActivity() throws IOException {
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

