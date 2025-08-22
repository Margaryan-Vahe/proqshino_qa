package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class MyPassesPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver;



    // Локаторы элементов страницы
    public abstract SelenideElement pageHeader();
    public abstract SelenideElement personalPassTab();
    public abstract SelenideElement guestPassTab();
    public abstract SelenideElement qrActive();
    public abstract SelenideElement qrOnApproval();
    public abstract SelenideElement deactivationButton();

    // Конструктор класса
    public MyPassesPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // Методы класса
    @Step("Жду загрузки экрана 'Мои пропуска'")
    public MyPassesPageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }
    @Step("Перехожу в таб 'Личные'")
    public void clickToPersonalTab(){
        personalPassTab().shouldBe(visible).click();
    }
    @Step("Перехожу в таб 'Гостевые'")
    public void clickToGuestTab(){
        guestPassTab().shouldBe(visible).click();
    }
    @Step("Ожидаю статус у QR пропуска 'Активен'")
    public void checkQRActiveStatus(){
       qrActive().shouldBe(visible);
    }
    @Step("Ожидаю статус у QR пропуска 'На согласовании'")
    public void checkQROnApprovalStatus(){
        qrOnApproval().shouldBe(visible);
    }
    @Step("Нажимаю на кнопку 'Деактивировать'")
    public void clickToDeactivateButton(){
        deactivationButton().shouldBe(visible);
    }
}
