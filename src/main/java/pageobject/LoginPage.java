package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Локатор для поля ввода email
    private final By emailInput = By.xpath(".//input[@name='name']");

    // Локатор для поля ввода password
    private final By passwordInput = By.xpath(".//input[@type='password']");

    // Локатор для кнопки "Войти"
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    // Локатор для кнопки "Конструктор"
    private final By constructorButton = By.xpath(".//nav/ul/li[1]/a");

    // Локатор для кнопки "Выйти"
    private final By exitButton = By.className("Account_button__14Yp3");

    // Локатор для логотипа Stellar Burgers
    private final By stellarBurgersLogo = By.xpath(".//div/header/nav/div");

    //Локатор для страницы входа
    private final By inputPage = By.xpath(".//div/main/div/h2");


    // Конструктор
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка, что по кнопке Зарегистрироваться осуществлен переход на страницу входа")
    public String checkLoginPage(){
        return driver.findElement(inputPage).getText();
    }

    @Step("Ввеси данные в поля формы входа в аккаунт: email, password")
    public void spellingField(String email, String password) {

        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);

    }

    @Step("Кликнуть по кнопке Войти")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Кликнуть по кнопке - Конструктор")
    public void clickConstructor() {
        driver.findElement(constructorButton).click();
    }

    @Step("Кликнуть по логотипу Stellar Burgers")
    public void clickLogo() {
        driver.findElement(stellarBurgersLogo).click();
    }

    @Step("Кликнуть по кнопке Выход")
    public void clickExit() {
        driver.findElement(exitButton).click();
    }

}



