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
        return $(MobileBy.AccessibilityId("QR"));
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


    // Конструктор класса
    public MyPassesPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса

}
