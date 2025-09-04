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

    public abstract SelenideElement interruptRegistrationWindow();

    public abstract SelenideElement interruptRegistrationButton();

    public abstract SelenideElement alreadyRegisteredPhoneErrorMessage();
    public abstract SelenideElement alreadyRegisteredEmailErrorMessage();


    public RegistrationPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Жду загрузки экрана 'Регистрация'")
    public RegistrationPageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Жду загрузки экрана предупреждения прерывания регистрации")
    public void waitUntilLoadedInterruptRegistrationWindow() {
        interruptRegistrationWindow().shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Жду отображения ошибки 'Данный номер уже зарегистрирован'")
    public void waitUntilLoadedAlreadyRegisteredPhoneMessage() {
        alreadyRegisteredPhoneErrorMessage().shouldBe(visible, Duration.ofSeconds(10));
    }
    @Step("Жду отображения ошибки 'Данный Email уже используется, пожалуйста, введите другой'")
    public void waitUntilLoadedAlreadyRegisteredEmailMessage() {
        alreadyRegisteredEmailErrorMessage().shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Ввожу номер телефона")
    public void typePhoneNumber(String phone) {
        waitUntilLoaded();
        phoneNumberField()
                .shouldBe(visible)
                .click();
        phoneNumberField().sendKeys(phone);
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
    public void successTypePhoneNumber(String phone) {
        typePhoneNumber(phone);
        activateCheckBox();
        clickToContinueButton();
    }

    @Step("Нажимаю на кнопку 'Прервать регистрацию'")
    public void clickToInterruptButton() {
        waitUntilLoadedInterruptRegistrationWindow();
        interruptRegistrationButton().shouldBe(visible).click();
    }

}
