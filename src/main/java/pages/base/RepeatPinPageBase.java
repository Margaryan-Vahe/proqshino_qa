package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.android.InputPinPageAndroid;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class RepeatPinPageBase <T> {
    AppiumDriver<MobileElement> appiumDriver;
    // Локаторы элементов страницы
    public abstract SelenideElement repeatPinHeader();
    public abstract SelenideElement num1();
    public abstract SelenideElement num2();

    // Конструктор класса
    public RepeatPinPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    public RepeatPinPageBase waitUntilLoaded() {
        repeatPinHeader().shouldBe(visible);
        return this;
    }

    public InputPinPageAndroid clickNum1(){
        for (int i = 1; i <= 4; i++){
            num1().click();
        }
        return new InputPinPageAndroid(appiumDriver);
    }
}
