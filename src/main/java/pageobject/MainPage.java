package pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ConstructorPage {
    private WebDriver driver;

    // Локатор для раздела "Булки"
    private final By bunsSection = By.xpath("//span[text()='Булки']");
    private final By headerBuns = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[1]");

    // Локатор для раздела "Соусы"
    private final By saucesSection = By.xpath("//span[text()='Соусы']");
    private final By headerSauces = By.xpath("//*[@id='root']/div/main/section[1]/div[2]/h2[2]");

    // Локатор для раздела "Начинки"
    private final By fillingsSection = By.xpath("//span[text()='Начинки']");
    private final By headerFillings = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[3]");

    // Конструктор
    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickSaucesSection() {
        driver.findElement(saucesSection).click();
    }

    public String getSaucesHeaderText() {
        return driver.findElement(headerSauces).getText();
    }

    public void clickFillingsSection() {
        driver.findElement(fillingsSection).click();
    }

    public String getFillingsHeaderText() {
        return driver.findElement(headerFillings).getText();
    }

    public void clickBunsSection() {
        driver.findElement(bunsSection).click();
    }

    public String getBunsHeaderText() {
        return driver.findElement(headerBuns).getText();
    }
}

