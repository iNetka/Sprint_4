import pageObjects.MainPage;
import pageObjects.OrderPage;
import pageObjects.RentPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ScooterOrderTest extends BaseTest {
    // Заказать через хедер
    @Test
    public void samokatOrderingByHeaderOrderButton() {
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

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("28.04.2025")
                .setRentalTime()
                .clickCheckBoxColourBlackPearl()
                .sendComment("Как можно быстрее")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Что-то пошло не так...", isDisplayed);
    }
    // Заказать на середине страницы
    @Test
    public void samokatOrderingByMiddleOrderButton() {
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

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("07.05.2025")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("Хочу кататься")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Что-то пошло не так...", isDisplayed);
    }
}