package ru.practikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private final WebDriver driver;

    private final By clientFirstName = By.xpath(".//input[@placeholder='* Имя']");
    private final By clientLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By deliveryAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By deliveryMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By deliveryClientPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By NextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage fillClientInfo(String firstName, String lastName, String address, String metroStation, String phoneNumber) {
        driver.findElement(clientFirstName).sendKeys(firstName);
        driver.findElement(clientLastName).sendKeys(lastName);
        driver.findElement(deliveryAddress).sendKeys(address);

        driver.findElement(deliveryMetroStation).click();
        driver.findElement(deliveryMetroStation).sendKeys(metroStation, Keys.DOWN, Keys.ENTER);

        driver.findElement(deliveryClientPhoneNumber).sendKeys(phoneNumber);
        return this;
    }

    public void clickNextButton() {
        driver.findElement(NextButton).click();
    }
}