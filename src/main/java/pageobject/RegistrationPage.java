package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    // Локатор для кнопки регистрации
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    // Локатор для поля ввода имени
    private final By nameInput = By.xpath( "//fieldset[1]/div/div/input");

    // Локатор для поля ввода email
    private final By emailInput = By.xpath("//fieldset[2]/div/div/input");

    // Локатор для поля ввода пароля
    private final By passwordInput = By.xpath("//input[@type='password']");
    //@FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input")

    // Локатор для сообщения об ошибке
    private final By errorMassage = By.className("input__error");

    //Локатор для страницы входа
    private final By inputPage = By.xpath(".//div/main/div/h2");

    //Локатор для кнопки - Войти
    private final By inputButton = By.className("Auth_link__1fOlj");

    // Конструктор
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Кликнуть по кнопке - Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Кликнуть по кнопке - Войти")
    public void clickInputButton() {
        driver.findElement(inputButton).click();
    }

    @Step("Ввеси данные в поля формы регистрации: name, email, password")
    public void spellingField(String name, String email, String password) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Проверка, что по кнопке Зарегистрироваться осуществлен переход на страницу входа")
    public String checkLoginPage(){
        return driver.findElement(inputPage).getText();
    }

    @Step("Получить сообщение об ошибке")
    public String getErrorText() {
        return driver.findElement(errorMassage).getText();
    }
}

