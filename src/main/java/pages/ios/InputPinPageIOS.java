package pages.ios;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.InputPinPageBase;

import static com.codeborne.selenide.Selenide.$;

public class InputPinPageIOS extends InputPinPageBase {
    // Локаторы элементов страницы
    @Override
    public final SelenideElement inputPinHeader(){
        return $(MobileBy.AccessibilityId("Введите PIN код"));
    }

    @Override
    public SelenideElement somethingWrongWithInternetModalWindow() {
        return $(MobileBy.AccessibilityId("Что-то с интернетом"));
    }

    public final SelenideElement num1(){
        return $(MobileBy.AccessibilityId("1"));
    }

    public final SelenideElement num2(){
       return $(MobileBy.AccessibilityId("2"));
    }


    // Конструктор класса
    public InputPinPageIOS(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса
}
