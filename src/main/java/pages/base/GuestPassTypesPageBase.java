package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class GuestPassTypesPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver;

    // Локаторы элементов страницы
    public abstract SelenideElement pageHeader();
    public abstract SelenideElement qrPass();


    // Конструктор класса
    public GuestPassTypesPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    @Step("Жду загрузки экрана 'Выберите тип пропуска'")
    public GuestPassTypesPageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Выбираю 'QR' пропуск")
    public void clickToQRPassButton(){
        qrPass()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

}
