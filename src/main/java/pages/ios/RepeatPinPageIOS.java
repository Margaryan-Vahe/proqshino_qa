package pages.ios;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.verificationPage.pinPage.InputPinPageBase;
import pages.base.verificationPage.pinPage.RepeatPinPageBase;

import static com.codeborne.selenide.Selenide.$;

public class RepeatPinPageIOS extends RepeatPinPageBase {
    // Локаторы элементов страницы
    @Override
    public final SelenideElement repeatPinHeader(){
       return $(MobileBy.AccessibilityId("Повторите PIN-код"));
    }
    @Override
    public final SelenideElement num1(){
        return $(MobileBy.AccessibilityId("1"));
    }
    @Override
    public final SelenideElement num2(){
        return $(MobileBy.AccessibilityId("2"));
    }


    // Конструктор класса
    public RepeatPinPageIOS(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @Override
    protected InputPinPageBase createInputPinPage() {
        return null;
    }

    // Методы класса
}
