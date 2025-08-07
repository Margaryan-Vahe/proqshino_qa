package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import static com.codeborne.selenide.Condition.visible;

public abstract class InputPinPageBase {
    AppiumDriver<MobileElement> appiumDriver;
    // Локаторы элементов страницы
    public abstract SelenideElement inputPinHeader();
    public abstract SelenideElement somethingWrongWithInternetModalWindow();
    public abstract SelenideElement num1();
    public abstract SelenideElement num2();
    public abstract SelenideElement forgotPinButton();

    // Конструктор класса
    public InputPinPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    public InputPinPageBase waitUntilLoaded() {
        inputPinHeader().shouldBe(visible);
        return this;
    }

    public void clickNum1(){
        for (int i = 1; i <= 4; i++){
            num1().click();
        }
    }
    public void clickNum2(){
        for (int i = 1; i <= 4; i++){
            num2().click();
        }
    }
    public void clickToForgotPinButton(){
        waitUntilLoaded();
        forgotPinButton().click();
    }
}
