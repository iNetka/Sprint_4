package ru.scooter.praktikum;

import org.junit.Test;
import ru.scooter.practikum.MainPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FAQParamTest extends BaseTest {

    // Сравнение текста
    @Test
    public void dropDownListTest() {
        MainPage mainPage = new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .scrollPageToEndOfList();

        assertTrue("Ответы на вопрос не равны ожидаемым", mainPage.CheckOnAnswers());

    }
}