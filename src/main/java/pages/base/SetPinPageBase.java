package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class SetPinPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver;

    // Локаторы
    public abstract SelenideElement setPinHeader();
    public abstract SelenideElement num1();
    public abstract SelenideElement num2();

    public SetPinPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Жду загрузки экрана 'Установите PIN-код'")
    public SetPinPageBase waitUntilLoaded() {
        setPinHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Ввожу PIN: 1111")
    public void clickNum1() {
        num1().shouldBe(visible, Duration.ofSeconds(10));
        for (int i = 0; i < 4; i++) {
            num1().click();
        }
    }

    // опционально; симметрия с вводом неверного PIN (если пригодится)
    @Step("Ввожу PIN: 2222")
    public void clickNum2() {
        num2().shouldBe(visible, Duration.ofSeconds(10));
        for (int i = 0; i < 4; i++) {
            num2().click();
        }
    }
}
