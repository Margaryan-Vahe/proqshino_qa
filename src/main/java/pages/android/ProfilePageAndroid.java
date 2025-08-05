package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.ProfilePageBase;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePageAndroid extends ProfilePageBase {

    @Override
    public final SelenideElement pageHeader() {
        return $(MobileBy.AccessibilityId("Профиль"));
    }

    // Конструктор класса
    public ProfilePageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса
}
