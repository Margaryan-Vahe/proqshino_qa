package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pages.base.PassCreationMainPageBase;
import pages.base.SetPasswordPageBase;

import static com.codeborne.selenide.Selenide.$;

public class PassCreationMainPageAndroid extends PassCreationMainPageBase {
    // Элементы страницы

    @Override
    public SelenideElement pageHeader() {
        return $(MobileBy.AccessibilityId("Система контроля доступа"));
    }

    @Override
    public SelenideElement personalPass() {
        return $(MobileBy.AccessibilityId("Личный пропуск"));
    }

    @Override
    public SelenideElement guestPass() {
        return $(MobileBy.AccessibilityId("Гостевой пропуск"));
    }

    @Override
    public SelenideElement myPasses() {
        return $(MobileBy.AccessibilityId("Мои пропуска"));
    }

    // Конструктор класса
    public PassCreationMainPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса

}
