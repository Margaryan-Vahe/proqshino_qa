package pages.android.mainPage.passPage.passTypesPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.mainPage.passPage.passTypesPage.PersonalPassTypesPageBase;

import static com.codeborne.selenide.Selenide.$;

public class PersonalPassTypesPageAndroid extends PersonalPassTypesPageBase {
    // Элементы страницы

    @Override
    public SelenideElement pageHeader() {
        return $(MobileBy.AccessibilityId("Система контроля доступа"));
    }

    @Override
    public SelenideElement qrPass() {
        return $(MobileBy.xpath("//android.view.View[contains(@content-desc, 'QR')]"));
    }

    // Конструктор класса
    public PersonalPassTypesPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса

}
