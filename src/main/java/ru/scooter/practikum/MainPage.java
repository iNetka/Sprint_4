package ru.practikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

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

    private By Questions = By.xpath("//div[contains(@id,\"accordion__heading\")]");
    private By Answers = By.xpath("//div[contains(@id,\"accordion__panel\")]/p");

    public By getQuestionsLocator() {
        return Questions;
    }

    public By getAnswersLocator() {
        return Answers;
    }

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

    private static final String[] textOfAnswers = new String[]{
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
    };

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

    // Поиск вопросов и ответов
    public boolean CheckOnAnswers() {
        List<WebElement> listOfQuestions = driver.findElements(this.Questions);
        List<WebElement> listOfAnswers = driver.findElements(this.Answers);
        // Сравнение найденных ответов
        if (listOfAnswers.size() != textOfAnswers.length) {
            return false;
        }

        // Сравнение ответов
        WebDriverWait wait = new WebDriverWait(driver, 5);
        for (int i = 0; i < listOfAnswers.size(); i++) {
            wait.until(ExpectedConditions.elementToBeClickable(listOfQuestions.get(i))).click();
            String AnswersText = wait.until(ExpectedConditions.visibilityOf(listOfAnswers.get(i))).getText();
            if (!Objects.equals(AnswersText, textOfAnswers[i])) {
                return false;
            }
        }
        return true;
    }
}
