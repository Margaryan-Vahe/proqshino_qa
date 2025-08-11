package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.InputPinPageBase;

import static com.codeborne.selenide.Selenide.$;

public class InputPinPageAndroid extends InputPinPageBase {

    @Override
    public SelenideElement inputPinHeader(){
        return $(MobileBy.AccessibilityId("Введите PIN код"));
    }

    @Override
    public SelenideElement somethingWrongWithInternetModalWindow() {
        return $(MobileBy.AccessibilityId("Что-то с интернетом"));
    }

    @Override
    public SelenideElement num1(){
        return $(MobileBy.AccessibilityId("1"));
    }

    @Override
    public SelenideElement num2(){
        return $(MobileBy.AccessibilityId("2"));
    }

    @Override
    public SelenideElement forgotPinButton() {
        return $(MobileBy.AccessibilityId("Забыл ПИН-код"));
    }

    public InputPinPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }
}
