package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public abstract class LoginPageBase implements pages.BaseProfilePage {
    protected final AppiumDriver<MobileElement> appiumDriver;

    // Локаторы
    @Override
    public abstract SelenideElement pageHeader();
    public abstract SelenideElement phoneNumberField();
    public abstract SelenideElement passwordField();
    public abstract SelenideElement loginButton();
    public abstract SelenideElement incorrectDataErrorMessage();
    public abstract SelenideElement forgotPassButton();
    public abstract SelenideElement createNewAccountButton();

    public LoginPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Жду загрузки страницы логина")
    public LoginPageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible);
        return this;
    }

    @Step("Читаю заголовок страницы логина")
    public String getPageHeaderText() {
        return pageHeader().getText();
    }

    @Step("Ввожу номер телефона: {phoneNumber}")
    public void typePhoneNumber(String phoneNumber) {
        waitUntilLoaded();
        SelenideElement phone = phoneNumberField().shouldBe(visible).shouldBe(enabled);

        phone.click();
        phone.sendKeys(phoneNumber);
    }

    @Step("Ввожу пароль")
    public void typePassword(String pass) {
        SelenideElement password = passwordField()
                .shouldBe(visible,enabled);

        password.click();
        password.sendKeys(pass);
    }

    @Step("Нажимаю кнопку 'Войти'")
    public void clickToLoginButton() throws InterruptedException {
        Thread.sleep(1500);
        loginButton().click();
    }

    @Step("Открываю 'Забыл пароль'")
    public void clickToForgotPassButton() {
        waitUntilLoaded();
        forgotPassButton().shouldBe(visible).click();
    }
    @Step("Нажимаю на кнопку 'Нет аккаунта? Зарегистрируйтесь'")
    public void clickToCreateNewAccountButton() {
        waitUntilLoaded();
        createNewAccountButton().shouldBe(visible).click();
    }
}
