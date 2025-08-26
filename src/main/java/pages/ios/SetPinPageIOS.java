package pages.ios;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.verificationPage.pinPage.SetPinPageBase;

import static com.codeborne.selenide.Selenide.$;

public class SetPinPageIOS extends SetPinPageBase {
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
    public SetPinPageIOS(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса
}
