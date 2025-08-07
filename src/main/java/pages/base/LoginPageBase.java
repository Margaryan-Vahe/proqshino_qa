package pages.base;

import baseUtils.Data;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.BaseProfilePage;
import pages.android.*;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public abstract class LoginPageBase implements BaseProfilePage {
    public static AppiumDriver<MobileElement> appiumDriver;
    MainPageAndroid mainPageAndroid = new MainPageAndroid(appiumDriver);
    SetPinPageAndroid setPinPageAndroid = new SetPinPageAndroid(appiumDriver);;
    RepeatPinPageAndroid repeatPinPageAndroid = new RepeatPinPageAndroid(appiumDriver);
    InputPinPageAndroid inputPinPageAndroid = new InputPinPageAndroid(appiumDriver);
    BioConfirmationPageAndroid bioConfirmationPageAndroid = new BioConfirmationPageAndroid(appiumDriver);

    // Локаторы элементов страницы
    @Override
    public SelenideElement pageHeader() {
        return null;
    }

    public abstract SelenideElement phoneNumberField();
    public abstract SelenideElement passwordField();
    public abstract SelenideElement loginButton();
    public abstract SelenideElement incorrectDataErrorMessage();
    public abstract SelenideElement forgotPassButton();

    // Конструктор класса
    public LoginPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    public LoginPageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible);
        return this;
    }
    public String getPageHeaderText(){
        return pageHeader().getText();
    }

    public void typePhoneNumber(String phoneNumber) throws InterruptedException {
        do {
            SelenideElement phone = phoneNumberField()
                    .shouldBe(visible, enabled);
            phone.click();
            phone.sendKeys(phoneNumber);
        } while (!phoneNumberField()
                .getText()
                .equals(Data.UserTypes.DEFAULT_USER.phoneFullValue()));
    }

    public void typePassword(String pass) {
        passwordField().click();
        passwordField()
                .shouldBe(visible, enabled)
                .sendKeys(pass);
    }

    public void clickToLoginButton() throws InterruptedException {
        Thread.sleep(1500);
        loginButton().click();
    }

    public void login(String phone, String pass, boolean isErrorCase) throws InterruptedException {
        typePhoneNumber(phone);
        typePassword(pass);
        clickToLoginButton();

        if(isErrorCase){
            incorrectDataErrorMessage().shouldBe(visible);
        } else {
            setPinPageAndroid.clickNum1();
            repeatPinPageAndroid.clickNum1();
            bioConfirmationPageAndroid.clickToRefuseButton();
            inputPinPageAndroid.clickNum1();

            mainPageAndroid.mainPageHeaderShouldNeVisible();
        }
    }
    public void clickToForgotPassButton() {
        waitUntilLoaded();
        forgotPassButton().click();
    }
}
