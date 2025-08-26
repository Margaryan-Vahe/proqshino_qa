// pages.android.verificationPage.BioConfirmationPageAndroid — ИЗМЕНЁННЫЙ КОД
package pages.android.verificationPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pages.base.verificationPage.BioConfirmationPageBase;

import static com.codeborne.selenide.Selenide.$;

public class BioConfirmationPageAndroid extends BioConfirmationPageBase {

    // Локаторы
    @Override
    public SelenideElement bioModalWindow() {
        return $(MobileBy.AccessibilityId("PIN-код успешно установлен"));
    }

    @Override
    public SelenideElement confirmBiometricButton(){
        return $(MobileBy.AccessibilityId("Подключить вход по биометрии"));
    }

    @Override
    public SelenideElement refuseBiometricButton(){
        return $(MobileBy.AccessibilityId("Я хочу отказаться от биометрического доступа"));
    }

    // Конструктор
    public BioConfirmationPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Ковариантный возврат для удобного чейнинга + явные шаги под Android
    @Override
    @Step("Жду появления модального окна подтверждения биометрии (Android)")
    public BioConfirmationPageAndroid waitUntilLoaded() {
        super.waitUntilLoaded();
        return this;
    }
}
