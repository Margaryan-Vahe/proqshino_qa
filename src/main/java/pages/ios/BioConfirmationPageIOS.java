package pages.ios;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.verificationPage.BioConfirmationPageBase;

import static com.codeborne.selenide.Selenide.$;

public class BioConfirmationPageIOS extends BioConfirmationPageBase {
    // Локаторы элементов страницы
    @Override
    public SelenideElement bioModalWindow() {
        return $(MobileBy.AccessibilityId("PIN‑код успешно установлен"));
    }
    @Override
    public SelenideElement refuseBiometricButton(){
        return $(MobileBy.AccessibilityId("Я хочу отказаться от биометрического доступа"));
    }

    // Конструктор класса
    public BioConfirmationPageIOS(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса
}
