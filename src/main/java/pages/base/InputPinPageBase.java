package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public abstract class InputPinPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver;

    public abstract SelenideElement inputPinHeader();
    public abstract SelenideElement somethingWrongWithInternetModalWindow();
    public abstract SelenideElement num1();
    public abstract SelenideElement num2();
    public abstract SelenideElement forgotPinButton();

    public InputPinPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Жду загрузки экрана ввода PIN")
    public InputPinPageBase waitUntilLoaded() {
        inputPinHeader().shouldBe(visible);
        return this;
    }

    @Step("Ввожу PIN: 1111")
    public void clickNum1(){
        num1().shouldBe(visible);
        for (int i = 0; i < 4; i++) num1().click();
    }

    @Step("Ввожу PIN: 2222")
    public void clickNum2(){
        num2().shouldBe(visible);
        for (int i = 0; i < 4; i++) num2().click();
    }

    @Step("Нажимаю 'Забыл ПИН-код'")
    public void clickToForgotPinButton(){
        waitUntilLoaded();
        forgotPinButton().shouldBe(visible).click();
    }
}
