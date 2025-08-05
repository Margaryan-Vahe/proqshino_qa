package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.BioConfirmationPageBase;

import static com.codeborne.selenide.Selenide.$;

public class BioConfirmationPageAndroid extends BioConfirmationPageBase {
    // Локаторы элементов страницы
    @Override
    public SelenideElement bioModalWindow() {
        return $(MobileBy.AccessibilityId("PIN‑код успешно установлен"));
    }
    @Override
    public SelenideElement confirmBiometricButton(){
        return $(MobileBy.AccessibilityId("Подключить вход по биометрии"));
    }
    @Override
    public SelenideElement refuseBiometricButton(){
        return $(MobileBy.AccessibilityId("Я хочу отказаться от биометрического доступа"));
    }

    // Конструктор класса
    public BioConfirmationPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса
}
