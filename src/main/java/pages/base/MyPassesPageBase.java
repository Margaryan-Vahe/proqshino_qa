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

    public abstract SelenideElement approveDeactivatingModalWindow();

    public abstract SelenideElement approveDeactivatingButton();

    public abstract SelenideElement deactivatingSuccessModalWindow();

    public abstract SelenideElement myPassesButton();
    public abstract SelenideElement noActivePassMessage();

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
    public void clickToPersonalTab() {
        personalPassTab().shouldBe(visible).click();
    }

    @Step("Перехожу в таб 'Гостевые'")
    public void clickToGuestTab() {
        guestPassTab().shouldBe(visible).click();
    }

    @Step("Ожидаю статус у QR пропуска 'Активен'")
    public void checkQRActiveStatus() {
        waitUntilLoaded();
        qrActive().shouldBe(visible);
    }

    @Step("Ожидаю статус у QR пропуска 'На согласовании'")
    public void checkQROnApprovalStatus() {
        waitUntilLoaded();
        qrOnApproval().shouldBe(visible);
    }

    @Step("Нажимаю на кнопку 'Деактивировать'")
    public void clickToDeactivateButton() {
        waitUntilLoaded();
        deactivationButton().shouldBe(visible).click();
    }

    @Step("Жду загрузки экрана 'Деактивировать пропуск?'")
    public void waitUntilLoadedDeactivationModalWindow() {
        approveDeactivatingModalWindow().shouldBe(visible);
    }

    @Step("Подтвеждаю деактивацию пропуска: нажимая на 'Да, деактивировать пропуск'")
    public void clickToApproveDeactivatingButton() {
        waitUntilLoadedDeactivationModalWindow();
        approveDeactivatingButton().shouldBe(visible).click();
    }

    @Step("Жду загрузки экрана 'Успешно'")
    public void waitUntilLoadedDeactivatingSuccessModalWindow() {
        deactivatingSuccessModalWindow().shouldBe(visible);
    }

    @Step("Нажимаю на кнопку 'Деактивировать'")
    public void clickToMyPassesButton() {
        waitUntilLoadedDeactivatingSuccessModalWindow();
        myPassesButton().shouldBe(visible).click();
    }
    @Step("Жду отображения сообщения 'Нет активных пропусков'")
    public void waitUntilLoadedNoActivePassMessage() {
        noActivePassMessage().shouldBe(visible);
    }

    @Step("Деактивирую пропуск")
    public void deactivatePass() {
        clickToDeactivateButton();
        clickToApproveDeactivatingButton();

        clickToMyPassesButton();
        waitUntilLoadedNoActivePassMessage();
    }
}
