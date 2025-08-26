// pages.android.verificationPage.pinPage.SetPinPageAndroid — ИЗМЕНЁННЫЙ КОД
package pages.android.verificationPage.pinPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pages.base.verificationPage.pinPage.SetPinPageBase;

import static com.codeborne.selenide.Selenide.$;

public class SetPinPageAndroid extends SetPinPageBase {

    @Override
    public SelenideElement setPinHeader() {
        return $(MobileBy.AccessibilityId("Установите PIN-код"));
    }

    @Override
    public SelenideElement num1() {
        return $(MobileBy.AccessibilityId("1"));
    }

    @Override
    public SelenideElement num2() {
        return $(MobileBy.AccessibilityId("2"));
    }

    public SetPinPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // ковариантный тип для красивого чейнинга + явные шаги под Android
    @Override
    @Step("Жду загрузки экрана 'Установите PIN-код' (Android)")
    public SetPinPageAndroid waitUntilLoaded() {
        super.waitUntilLoaded();
        return this;
    }
}
