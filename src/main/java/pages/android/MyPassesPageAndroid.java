package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.MyPassesPageBase;

import static com.codeborne.selenide.Selenide.$;

public class MyPassesPageAndroid extends MyPassesPageBase {
    // Элементы страницы

    @Override
    public SelenideElement pageHeader() {
        return $(MobileBy.AccessibilityId("Мои пропуска"));
    }

    @Override
    public SelenideElement personalPassTab() {
        return $(MobileBy.AccessibilityId("Личные"));
    }

    @Override
    public SelenideElement guestPassTab() {
        return $(MobileBy.AccessibilityId("Гостевые"));
    }

    @Override
    public SelenideElement qrActive() {
        return $(MobileBy.xpath("//android.view.View[contains(@content-desc,'QR\n" +
                "Активен')]"));
    }

    @Override
    public SelenideElement qrOnApproval() {
        return $(MobileBy.xpath("//android.view.View[contains(@content-desc,'QR\n" +
                "На согласовании')]"));
    }

    @Override
    public SelenideElement deactivationButton() {
        return $(MobileBy.AccessibilityId("Деактивировать"));
    }

    @Override
    public SelenideElement approveDeactivatingModalWindow() {
        return $(MobileBy.AccessibilityId("Деактивировать пропуск?"));
    }

    @Override
    public SelenideElement approveDeactivatingButton() {
        return $(MobileBy.AccessibilityId("Да, деактивировать пропуск"));
    }

    @Override
    public SelenideElement deactivatingSuccessModalWindow() {
        return $(MobileBy.AccessibilityId("Успешно"));
    }

    @Override
    public SelenideElement myPassesButton() {
        return $(MobileBy.AccessibilityId("Мои пропуска"));
    }

    @Override
    public SelenideElement noActivePassMessage() {
        return $(MobileBy.AccessibilityId("Нет активных пропусков"));
    }

    @Override
    public SelenideElement createNewPersonalPassButton() {
        return $(MobileBy.AccessibilityId("Создать личный пропуск"));
    }

    @Override
    public SelenideElement createNewGuestPassButton() {
        return $(MobileBy.AccessibilityId("Создать гостевой пропуск"));
    }

    @Override
    public SelenideElement QR() {
        return $(MobileBy.AccessibilityId("qr code"));
    }


    // Конструктор класса
    public MyPassesPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса

}
