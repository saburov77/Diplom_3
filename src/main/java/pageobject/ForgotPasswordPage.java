package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    //Локатор для кнопки - Войти
    private final By inputButton = By.className("Auth_link__1fOlj");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Кликнуть по кнопке - Войти")
    public void clickInputButton() {
        driver.findElement(inputButton).click();
    }


}
