package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import static com.codeborne.selenide.Condition.visible;

public abstract class SetPinPageBase {
    AppiumDriver<MobileElement> appiumDriver;
    // Локаторы элементов страницы
    public abstract SelenideElement setPinHeader();
    public abstract SelenideElement num1();
    public abstract SelenideElement num2();

    // Конструктор класса
    public SetPinPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    public void waitUntilLoaded() {
        setPinHeader().shouldBe(visible);
    }

    public void clickNum1(){
        for (int i = 1; i <= 4; i++){
            num1().click();
        }
    }
}
