package pages.base;

import baseUtils.Data;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public abstract class RecoveryPageBase {
    public static AppiumDriver<MobileElement> appiumDriver;

    // Локаторы элементов страницы
    public abstract SelenideElement pageHeader();

    public abstract SelenideElement phoneNumberField();

    public abstract SelenideElement continueButton();

    public abstract SelenideElement noAccessToPhoneButton();

    public abstract SelenideElement alreadyHaveAccountButton();

    // Конструктор класса
    public RecoveryPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    public void waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
    }

    public void typePhoneNumber(String phoneNumber) {
        SelenideElement phone = phoneNumberField();
        phone.click();
        phone.sendKeys(phoneNumber);
    }

    public void clickToContinueButton() throws InterruptedException {
        Thread.sleep(1500);
        continueButton().click();


    }

    public void inputDataForRecover(String phoneNumber) throws InterruptedException {
        waitUntilLoaded();

        typePhoneNumber(phoneNumber);
        clickToContinueButton();
    }
}
