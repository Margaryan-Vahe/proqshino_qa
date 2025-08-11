package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class RepeatPinPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver;

    // Локаторы элементов страницы
    public abstract SelenideElement repeatPinHeader();
    public abstract SelenideElement num1();
    public abstract SelenideElement num2();

    public RepeatPinPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Жду загрузки экрана 'Повторите PIN-код'")
    public RepeatPinPageBase waitUntilLoaded() {
        repeatPinHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Повторяю PIN: 1111")
    public InputPinPageBase clickNum1(){
        num1().shouldBe(visible, Duration.ofSeconds(10));
        for (int i = 0; i < 4; i++){
            num1().click();
        }
        return createInputPinPage();
    }

    @Step("Повторяю PIN: 2222")
    public InputPinPageBase clickNum2(){
        num2().shouldBe(visible, Duration.ofSeconds(10));
        for (int i = 0; i < 4; i++){
            num2().click();
        }
        return createInputPinPage();
    }

    // фабрика следующей страницы — реализуется в наследниках (Android/iOS)
    protected abstract InputPinPageBase createInputPinPage();
}
