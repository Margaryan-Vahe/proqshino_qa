package pages.ios;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.mainPage.MainPageBase;

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

    @Override
    public SelenideElement passButton() {
        return $(MobileBy.xpath("//android.view.View[contains(@content-desc, 'Пропуск')]"));
    }

    @Override
    public SelenideElement QRButton() {
        return null;
    }

    @Override
    public SelenideElement QRCode() {
        return null;
    }


    // Конструктор класса
    public MainPageIOS(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса
}
