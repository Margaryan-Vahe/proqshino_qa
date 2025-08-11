package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class RecoveryPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver;

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
    @Step("Жду загрузки экрана восстановления")
    public RecoveryPageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Ввожу номер телефона для восстановления: {phoneNumber}")
    public RecoveryPageBase typePhoneNumber(String phoneNumber) {
        phoneNumberField()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();

        phoneNumberField().sendKeys(phoneNumber);
        return this;
    }

    @Step("Нажимаю кнопку 'Продолжить'")
    public void clickToContinueButton() throws InterruptedException {
        Thread.sleep(1500); // осознанно оставлено
        continueButton()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    @Step("Заполняю данные для восстановления и продолжаю")
    public void inputDataForRecover(String phoneNumber) throws InterruptedException {
        waitUntilLoaded();
        typePhoneNumber(phoneNumber);
        clickToContinueButton();
    }
}
