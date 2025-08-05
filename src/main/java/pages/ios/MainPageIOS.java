package pages.ios;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.MainPageBase;

import static com.codeborne.selenide.Selenide.$;

public class MainPageIOS extends MainPageBase {
    // Локаторы элементов страницы
    @Override
    public final SelenideElement mainPageHeader() {
        return $(MobileBy.AccessibilityId("Управляющая компания"));
    }

    @Override
    public final SelenideElement profileButton() {
        return $(MobileBy.AccessibilityId("Профиль"));
    }

    // Конструктор класса
    public MainPageIOS(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса
}
