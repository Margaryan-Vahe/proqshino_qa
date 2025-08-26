package pages.android.mainPage.passPage.passTypesPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.base.mainPage.passPage.passTypesPage.QrPassMainPageBase;

import static com.codeborne.selenide.Selenide.$;

public class QrPassMainPageAndroid extends QrPassMainPageBase {
    // Элементы страницы

    @Override
    public SelenideElement pageHeader() {
        return $(MobileBy.AccessibilityId("QR"));
    }

    @Override
    public SelenideElement alreadyHavePassText() {
        return $(MobileBy.AccessibilityId("У вас уже есть пропуск QR"));
    }

    @Override
    public SelenideElement generateButton() {
        return $(MobileBy.AccessibilityId("Сгенерировать"));
    }

    @Override
    public SelenideElement modalWindowSuccessApproved() {
        return $(MobileBy.xpath("//android.view.View[contains(@content-desc, 'Пропуск сформирован')]"));
    }

    @Override
    public SelenideElement modalWindowSuccessNotApproved() {
        return $(MobileBy.AccessibilityId("Для вас согласован доступ в БК \"Прокшино\". Пожалуйста, предъявите паспорт на ресепшен для подтверждения личности."));
    }

    @Override
    public SelenideElement checkBoxIllGoToReception() {
        return $(MobileBy.AccessibilityId("Я подойду на ресепшен с паспортом"));
    }

    @Override
    public SelenideElement confirmRadioButton() {
        return $(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(6)"));
    }

    @Override
    public SelenideElement myPassesButton() {
        return $(MobileBy.AccessibilityId("Мои пропуска"));
    }

    // Конструктор класса
    public QrPassMainPageAndroid(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    // Методы класса

}
