package ru.scooter.praktikum;

import org.junit.Test;
import ru.scooter.practikum.MainPage;
import ru.scooter.practikum.OrderPage;
import ru.scooter.practikum.RentPage;

import static org.junit.Assert.assertTrue;

public class ScooterOrderTest extends BaseTest {

    // Заказать через хедер
    @Test
    public void OrderByHeaderButtonTest() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickHeaderOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Мария")
                .sendClientLastName("Иванова")
                .sendDeliveryAddress("Москва, Мира, 10")
                .selectMetroStation("Сухаревская")
                .sendDeliveryClientPhoneNumber("89169161234")
                .clickNextButton();

        RentPage rentPage = new RentPage(driver)
                .sendRentalDate("28.04.2025")
                .setRentalTime()
                .clickCheckBoxColourBlackPearl()
                .sendComment("Как можно быстрее")
                .clickOrderButton()
                .clickOrderButtonYes();

        assertTrue("Что-то пошло не так...", rentPage.checkOrderCreated());
    }
    // Заказать на середине страницы
    @Test
    public void OrderByMiddleButtonTest() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickMiddleOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Иван")
                .sendClientLastName("Петров")
                .sendDeliveryAddress("Москва, Окская, 7")
                .selectMetroStation("Рязанский проспект")
                .sendDeliveryClientPhoneNumber("89269261231")
                .clickNextButton();

       RentPage rentPage = new RentPage(driver)
                .sendRentalDate("07.05.2025")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("Хочу кататься")
                .clickOrderButton()
                .clickOrderButtonYes();

        assertTrue("Что-то пошло не так...", rentPage.checkOrderCreated());
    }
}