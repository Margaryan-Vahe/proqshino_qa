package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.SetPinPageBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class SetPinPageAndroid extends SetPinPageBase {
    // Локаторы элементов страницы
    @Override
    public final SelenideElement setPinHeader(){
        return $(MobileBy.AccessibilityId("Установите PIN-код"));
    }

    public final SelenideElement num1(){
        return $(MobileBy.AccessibilityId("1"));
    }

    public final SelenideElement num2(){
       return $(MobileBy.AccessibilityId("2"));
    }


    // Конструктор класса
    public SetPinPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса
}
