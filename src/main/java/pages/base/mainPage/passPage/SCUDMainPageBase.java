package pages.base.mainPage.passPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class SCUDMainPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver;

    // Локаторы элементов страницы
    public abstract SelenideElement pageHeader();
    public abstract SelenideElement personalPass();
    public abstract SelenideElement guestPass();
    public abstract SelenideElement myPasses();

    // Конструктор класса
    public SCUDMainPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    @Step("Жду загрузки экрана 'Задайте пароль'")
    public SCUDMainPageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Перехожу в раздел 'Личные пропуска'")
    public void clickToPersonalPassButton(){
        personalPass()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }
    @Step("Перехожу в раздел 'Гостевые пропуска'")
    public void clickToGuestPassButton(){
        guestPass()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }
    @Step("Перехожу в раздел 'Мои пропуска'")
    public void clickMyPassesButton(){
        myPasses()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

}
