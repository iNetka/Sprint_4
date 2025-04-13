package ru.scooter.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practikum.scooter.MainPage;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class FAQParamTest extends BaseTest {

    private final int questionIndex;
    private final String expectedAnswer;

    public FAQParamTest(int questionIndex, String expectedAnswer) {
        this.questionIndex = questionIndex;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }

    @Test
    public void dropDownListTest() {
        MainPage mainPage = new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .scrollPageToEndOfList();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        // Получаем список вопросов и ответов
        List<WebElement> questions = driver.findElements(mainPage.getQuestionsLocator());
        List<WebElement> answers = driver.findElements(mainPage.getAnswersLocator());
        wait.until(ExpectedConditions.elementToBeClickable(questions.get(questionIndex))).click();
        // Проверяем конкретный вопрос-ответ
        questions.get(questionIndex).click();
        String actualAnswer = answers.get(questionIndex).getText();

        assertTrue("Ответ на вопрос #" + questionIndex + " не соответствует ожидаемому",
                expectedAnswer.equals(actualAnswer));
    }
}