import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.MainPage;
import service.Browser;

import java.io.IOException;

import static service.Constants.MAIN_PAGE_URL;


public class ConstructorTest {

    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void startActivity() throws IOException {
        driver = Browser.initDriver();
        driver.get(MAIN_PAGE_URL);
        mainPage = new MainPage(driver);

    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }

    @Test
    @Description("Проверка перехода в раздел 'Соусы'")
    public void testSaucesSection() {
        mainPage.clickSaucesSection();
        Assert.assertEquals("Соусы", mainPage.getCurrentHeaderText());
    }

    @Test
    @Description("Проверка перехода в раздел 'Начинки'")
    public void testFillingsSection() {
        mainPage.clickFillingsSection();
        Assert.assertEquals("Начинки", mainPage.getCurrentHeaderText());
    }

    @Test
    @Description("Проверка перехода в раздел 'Булки'")
    public void testBunsSection() {
        mainPage.clickSaucesSection();
        mainPage.clickBunsSection();
        Assert.assertEquals("Булки", mainPage.getCurrentHeaderText());
    }
}
