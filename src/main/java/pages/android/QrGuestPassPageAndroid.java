package pages.android;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.QrGuestPassPageBase;

import static com.codeborne.selenide.Selenide.$;

public class QrGuestPassPageAndroid extends QrGuestPassPageBase {
    // Элементы страницы

    @Override
    public SelenideElement pageHeader() {
        return $(MobileBy.AccessibilityId("QR"));
    }

    @Override
    public SelenideElement lastNameField() {
        return $(MobileBy.xpath("(//android.view.View[@content-desc=\"Фамилия\"]/following-sibling::android.widget.EditText)[1]"));
    }

    @Override
    public SelenideElement firstNameField() {
        return $(MobileBy.xpath("(//android.view.View[@content-desc=\"Фамилия\"]/following-sibling::android.widget.EditText)[2]"));
    }

    @Override
    public SelenideElement secondNameField() {
        return $(MobileBy.xpath("(//android.view.View[@content-desc=\"Фамилия\"]/following-sibling::android.widget.EditText)[3]"));
    }

    @Override
    public SelenideElement emailField() {
        return $(MobileBy.xpath("(//android.view.View[@content-desc=\"Фамилия\"]/following-sibling::android.widget.EditText)[4]"));
    }

    @Override
    public SelenideElement phoneField() {
        return $(MobileBy.xpath("(//android.view.View[@content-desc=\"Фамилия\"]/following-sibling::android.widget.EditText)[5]"));
    }

    @Override
    public SelenideElement dateRangeField() {
        return $(MobileBy.xpath("(//android.view.View[@content-desc=\"Действие пропуска\"]/following-sibling::android.view.View)[1]"));
    }

    @Override
    public SelenideElement selectDateRangeWindow() {
        return $(MobileBy.xpath("//android.view.View[contains(@content-desc,'Выберите диапазон')]"));
    }

    @Override
    public SelenideElement saveButton() {
        return null;
    }

    @Override
    public SelenideElement generateButton() {
        return $(MobileBy.AccessibilityId("Сохранить"));
    }

    // Конструктор класса
    public QrGuestPassPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса

}
