package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.SetPersonalDataPageBase;

import java.util.Set;

import static com.codeborne.selenide.Selenide.$;

public class SetPersonalDataPageAndroid extends SetPersonalDataPageBase {
    @Override
    public SelenideElement pageHeader() {
        return $(MobileBy.AccessibilityId("Заполните данные"));
    }

    @Override
    public SelenideElement employeeRadioButton() {
        return $(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(7)"));
    }

    @Override
    public SelenideElement lastNameField() {
        return $(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
    }

    @Override
    public SelenideElement firstNameField() {
        return $(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
    }

    @Override
    public SelenideElement secondNameField() {
        return $(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
    }

    @Override
    public SelenideElement emailField() {
        return $(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)"));
    }

    @Override
    public SelenideElement innField() {
        return $(MobileBy.xpath("//android.view.View[@content-desc='ИНН компании']/following-sibling::android.widget.EditText"));
    }

    @Override
    public SelenideElement continueButton() {
        return $(MobileBy.AccessibilityId("Продолжить"));
    }

    @Override
    public SelenideElement regSuccessWindowNotApprovedCase() {
        return $(MobileBy.xpath("//android.view.View[contains(@content-desc, 'подтверждения вас')]"));
    }

    @Override
    public SelenideElement reviewedCheckBox() {
        return $(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(6)"));
    }

    @Override
    public SelenideElement toMainPageButton() {
        return $(MobileBy.AccessibilityId("На главный экран"));
    }

    @Override
    public SelenideElement regSuccessWindowUserCase() {
        return $(MobileBy.AccessibilityId("Вы успешно зарегистрировались"));
    }

    // Конструктор класса
    public SetPersonalDataPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }
}
