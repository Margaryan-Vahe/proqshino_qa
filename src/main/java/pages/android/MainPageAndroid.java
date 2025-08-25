package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.MainPageBase;

import static com.codeborne.selenide.Selenide.$;

public class MainPageAndroid extends MainPageBase {
    @Override
    public SelenideElement mainPageHeader() {
        return $(MobileBy.AccessibilityId("Управляющая компания"));
    }

    @Override
    public SelenideElement profileButton() {
        return $(MobileBy.AccessibilityId("Профиль"));
    }

    @Override
    public SelenideElement passButton() {
        return $(MobileBy.xpath("//android.view.View[contains(@content-desc, 'Пропуск')]"));
    }

    @Override
    public SelenideElement QRButton() {
        return $(MobileBy.AccessibilityId("Ваш QR-пропуск"));
    }

    @Override
    public SelenideElement QRCode() {
        return $(MobileBy.AccessibilityId("qr code"));
    }

    public MainPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }
}
