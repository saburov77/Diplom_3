package pageobject;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    // Локатор для раздела "Булки"
    private final By bunsSection = By.xpath("//span[text()='Булки']");
    private final By headerBuns = By.xpath(".//main/section[1]/div[2]/h2[1]");

    // Локатор для раздела "Соусы"
    private final By saucesSection = By.xpath("//span[text()='Соусы']");
    private final By headerSauces = By.xpath(".//main/section[1]/div[2]/h2[2]");

    // Локатор для раздела "Начинки"
    private final By fillingsSection = By.xpath("//span[text()='Начинки']");
    private final By headerFillings = By.xpath(".//main/section[1]/div[2]/h2[3]");

    // Локатор для кнопки "Войти в аккаунт"
    private final By loginAccountButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");

    private final By assembleBurgerLink = By.xpath(".//div/main/section[1]/h1");

    private final By personalCabinetButton = By.xpath(".//nav/a/p[text() = 'Личный Кабинет']");



    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы для работы с конструктором бургера

    @Step("Переход на вкладку Соусы")
    public void clickSaucesSection() {
        driver.findElement(saucesSection).click();
    }

    @Step("Получение текста заголовка вкладки Соусы")
    public String getSaucesHeaderText() {
        return driver.findElement(headerSauces).getText();
    }

    @Step("Переход на вкладку Начинки")
    public void clickFillingsSection() {
        driver.findElement(fillingsSection).click();
    }

    @Step("Получение текста заголовка вкладки Начинки")
    public String getFillingsHeaderText() {
        return driver.findElement(headerFillings).getText();
    }

    @Step("Переход на вкладку Булки")
    public void clickBunsSection() {
        driver.findElement(bunsSection).click();
    }

    @Step("Получение текста заголовка вкладки Булки")
    public String getBunsHeaderText() {
        return driver.findElement(headerBuns).getText();
    }

    @Step("Кликнуть по кнопке - Войти в аккаунт")
    public void clickLoginAccountButton() {

        driver.findElement(loginAccountButton).click();
    }

    @Step("Получение текста заголовка - Соберите бургер - проверка нахождения на главной странице")
    public String checkMainPage() {
        return driver.findElement(assembleBurgerLink).getText();
    }

    public void clickPersonalCabinetButton() {

        driver.findElement(personalCabinetButton).click();
    }


}

