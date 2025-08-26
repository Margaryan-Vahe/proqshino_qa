// pages.android.verificationPage.pinPage.RepeatPinPageAndroid — ИЗМЕНЁННЫЙ КОД
package pages.android.verificationPage.pinPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pages.base.verificationPage.pinPage.InputPinPageBase;
import pages.base.verificationPage.pinPage.RepeatPinPageBase;

import static com.codeborne.selenide.Selenide.$;

public class RepeatPinPageAndroid extends RepeatPinPageBase {

    @Override
    public SelenideElement repeatPinHeader(){
        return $(MobileBy.AccessibilityId("Повторите PIN-код"));
    }

    @Override
    public SelenideElement num1(){
        return $(MobileBy.AccessibilityId("1"));
    }

    @Override
    public SelenideElement num2(){
        return $(MobileBy.AccessibilityId("2"));
    }

    public RepeatPinPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @Override
    @Step("Жду загрузки экрана 'Повторите PIN-код' (Android)")
    public RepeatPinPageAndroid waitUntilLoaded() {
        super.waitUntilLoaded();
        return this;
    }

    @Override
    protected InputPinPageBase createInputPinPage() {
        return new InputPinPageAndroid(appiumDriver);
    }
}
