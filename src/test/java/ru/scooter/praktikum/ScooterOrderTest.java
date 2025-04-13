package ru.scooter.praktikum;

import org.junit.Test;
import ru.practikum.scooter.MainPage;
import ru.practikum.scooter.OrderPage;
import ru.practikum.scooter.RentPage;

import static org.junit.Assert.assertTrue;

public class ScooterOrderTest extends BaseTest {

    @Test
    public void OrderByHeaderButtonTest() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickHeaderOrderButton();

        new OrderPage(driver)
                .fillClientInfo("Мария", "Иванова", "Москва, Мира, 10", "Сухаревская", "89169161234")
                .clickNextButton();

        RentPage rentPage = new RentPage(driver)
                .fillRentInfo("28.04.2025", "black", "Как можно быстрее")
                .confirmOrder();

        assertTrue("Что-то пошло не так...", rentPage.checkOrderCreated());
    }

    @Test
    public void OrderByMiddleButtonTest() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickMiddleOrderButton();

        new OrderPage(driver)
                .fillClientInfo("Иван", "Петров", "Москва, Окская, 7", "Рязанский проспект", "89269261231")
                .clickNextButton();

        RentPage rentPage = new RentPage(driver)
                .fillRentInfo("07.05.2025", "grey", "Хочу кататься")
                .confirmOrder();

        assertTrue("Что-то пошло не так...", rentPage.checkOrderCreated());
    }
}