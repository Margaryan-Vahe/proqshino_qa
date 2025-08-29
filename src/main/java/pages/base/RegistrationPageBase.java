package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class RegistrationPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver;

    // Локаторы экрана
    public abstract SelenideElement pageHeader();
    public abstract SelenideElement phoneNumberField();
    public abstract SelenideElement mandatoryCheckBox();
    public abstract SelenideElement userAgreement();

    public abstract SelenideElement continueButton();


    public RegistrationPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Жду загрузки экрана 'Регистрация'")
    public RegistrationPageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }
    @Step("Ввожу номер телефона")
    public void typePhoneNumber() {
        waitUntilLoaded();
        phoneNumberField()
                .shouldBe(visible)
                .click();
    }
    @Step("Активирую чек-бокс согласия с политикой конфиденциальности")
    public void activateCheckBox() {
        waitUntilLoaded();
        mandatoryCheckBox()
                .shouldBe(visible)
                .click();
    }
    @Step("Нажимю на кнопку 'Продолжить'")
    public void clickToContinueButton() {
        waitUntilLoaded();
        continueButton()
                .shouldBe(visible)
                .click();
    }
    @Step("Успешно ввожу номер телефона -> активирую чек-бокс -> нажимаю на кнопку 'Продолжить'")
    public void successTypePhoneNumber() {
        typePhoneNumber();
        activateCheckBox();
        clickToContinueButton();
    }

}
