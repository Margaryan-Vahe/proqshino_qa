package pages.android.mainPage.passPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.mainPage.passPage.SCUDMainPageBase;

import static com.codeborne.selenide.Selenide.$;

public class SCUDMainPageAndroid extends SCUDMainPageBase {
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
    public SCUDMainPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса

}
