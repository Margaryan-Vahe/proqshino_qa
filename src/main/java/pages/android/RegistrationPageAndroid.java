package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.RegistrationPageBase;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageAndroid extends RegistrationPageBase {
    @Override
    public SelenideElement pageHeader() {
        return $(MobileBy.AccessibilityId("Регистрация"));
    }

    @Override
    public SelenideElement phoneNumberField() {
        return $(MobileBy.className("android.widget.EditText"));
    }

    @Override
    public SelenideElement mandatoryCheckBox() {
        return $(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(7)"));
    }

    @Override
    public SelenideElement userAgreement() {
        return $(MobileBy.AccessibilityId("условия пользовательского соглашения "));
    }

    @Override
    public SelenideElement continueButton() {
        return $(MobileBy.AccessibilityId("Продолжить"));
    }

    @Override
    public SelenideElement interruptRegistrationWindow() {
        return $(MobileBy.xpath("//android.view.View[contains(@content-desc, 'прервать регистрацию')]"));
    }

    @Override
    public SelenideElement interruptRegistrationButton() {
        return $(MobileBy.AccessibilityId("Прервать регистрацию"));
    }

    @Override
    public SelenideElement alreadyRegisteredPhoneErrorMessage() {
        return $(MobileBy.AccessibilityId("Данный номер уже зарегистрирован"));
    }

    // Конструктор класса
    public RegistrationPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }


}
