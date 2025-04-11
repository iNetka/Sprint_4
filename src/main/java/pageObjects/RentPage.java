package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPage {
    WebDriver driver;

    // Окно Про аренду
    // Когда привести самокат
    private final By rentalDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Выпадающий список Срок аренды
    private final By rentalTimeField = By.className("Dropdown-placeholder");
    // Срок аренды пятеро суток
    private final By rentalTime = By.xpath(".//*[(@role ='option' and text()='пятеро суток')]");
    // Цвет Черный жемчуг
    private final By checkBoxColourBlackPearl = By.xpath(".//input[@id='black']");
    // Цвет Серая безысходность
    private final By checkBoxColourGreyDespair = By.xpath(".//input[@id='grey']");
    // Комментария для курьера
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка Заказать
    private final By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    // Кнопка Да на поп-апе
    private final By orderButtonYes = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да')]");
    // Модальное окно
    private final By modalOrderWindow = By.xpath(".//div[contains(@class, 'Order_ModalHeader__3FDaJ')]");
    // Окно Заказ Оформлен
    public boolean isModalOrderWindowDisplayed() {
        return driver.findElement(modalOrderWindow).isDisplayed();
    }

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }
    // Страница Про аренду
    // Когда привести самокат
    public RentPage sendRentalDate(String date) {
        driver.findElement(rentalDateField).sendKeys(date);
        driver.findElement(rentalDateField).sendKeys(Keys.ENTER);
        return this;
    }

    // Срок аренды
    public RentPage setRentalTime() {
        driver.findElement(rentalTimeField).click();
        driver.findElement(rentalTime).click();
        return this;
    }

    // Цвет самоката Черный жемчуг
    public RentPage clickCheckBoxColourBlackPearl() {
        driver.findElement(checkBoxColourBlackPearl).click();
        return this;
    }

    // Цвет самоката Серая безысходность
    public RentPage clickCheckBoxColourGreyDespair() {
        driver.findElement(checkBoxColourGreyDespair).click();
        return this;
    }

    // Комментарий для курьера
    public RentPage sendComment(String userComment) {
        driver.findElement(commentField).sendKeys(userComment);
        return this;
    }

    // Клик по кнопке Заказать
    public RentPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    // Клик по кнопке Да на поп-апе
    public RentPage clickOrderButtonYes() {
        driver.findElement(orderButtonYes).click();
        return this;
    }
}