package pageobject;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    // Локатор для раздела "Булки"
    private final By bunsSection = By.xpath("//span[text()='Булки']");
    //Локатор для заголовка активного раздела
    private final By currentHeader = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]");

    // Локатор для раздела "Соусы"
    private final By saucesSection = By.xpath("//span[text()='Соусы']");


    // Локатор для раздела "Начинки"
    private final By fillingsSection = By.xpath("//span[text()='Начинки']");


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



    @Step("Переход на вкладку Начинки")
    public void clickFillingsSection() {
        driver.findElement(fillingsSection).click();
    }


    @Step("Переход на вкладку Булки")
    public void clickBunsSection() {
        driver.findElement(bunsSection).click();
    }

    @Step("Получение текста активного заголовка")
    public String getCurrentHeaderText() {
        return driver.findElement(currentHeader).getText();
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

