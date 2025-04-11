package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

// Главная страница
public class MainPage {
    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
    }

    private static WebDriver driver;

    // Кнопка Да все привыкли о куки
    private final By cookieButton = By.id("rcc-confirm-button");

    // Кнопка Заказать в хедере
    private By headerOrderButton = By.className("Button_Button__ra12g");

    // Кнопка Заказать на середине страницы
    private By middleOrderButton = By.className("Button_Middle__1CSJM");

    // Вопросы о важном
    private static final String[] dropDownQuestionsArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};

    // Ответы о важном
    private static final String[] dropDownAnswersArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};

    // Открыть сайт
    public final MainPage openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru");
        return this;
    }

    // Клик по кнопке Да все привыкли в сообщении о куки
    public MainPage clickCookieButton() {
        driver.findElement(cookieButton).click();
        return this;
    }

    // Клик по кнопке Заказать в хедере
    public MainPage clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
        return this;
    }

    // Клик по кнопке Заказа на середине страницы
    public MainPage clickMiddleOrderButton() {
        driver.findElement(middleOrderButton).click();
        return this;
    }

    // Прокрутка страницы
    public MainPage scrollPageToEndOfList() {
        WebElement lastQuestionArrow = driver.findElement(By.id(dropDownQuestionsArray[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
        return this;
    }
    // Клик по вопросу
    public MainPage clickQuestionButton(String questionButtonLocator) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
        return this;
    }
}