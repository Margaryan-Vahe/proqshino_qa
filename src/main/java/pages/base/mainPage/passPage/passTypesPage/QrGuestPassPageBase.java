package pages.base.mainPage.passPage.passTypesPage;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class QrGuestPassPageBase {
    protected final AppiumDriver<MobileElement> appiumDriver;

    public abstract SelenideElement pageHeader();

    public abstract SelenideElement lastNameField();

    public abstract SelenideElement firstNameField();

    public abstract SelenideElement secondNameField();

    public abstract SelenideElement emailField();

    public abstract SelenideElement phoneField();
    public abstract SelenideElement dateRangeField();
    public abstract SelenideElement selectDateRangeWindow();
    public abstract SelenideElement saveButton();
    private static final Locale RU = new Locale("ru", "RU");
    private static final DateTimeFormatter A11Y = DateTimeFormatter.ofPattern("dd.MM.yyyy", RU);

    public QrGuestPassPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Жду загрузки экрана 'QR'")
    public QrGuestPassPageBase waitUntilLoaded() {
        pageHeader().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Ввожу значение в поле 'Фамилия'")
    public void typeLastName(String value) {
        waitUntilLoaded();
        SelenideElement field = lastNameField();
        field.shouldBe(visible, Duration.ofSeconds(10)).click();
        field.sendKeys(value);
        appiumDriver.hideKeyboard();
    }

    @Step("Ввожу значение в поле 'Имя'")
    public void typeFirstName(String value) {
        waitUntilLoaded();
        SelenideElement field = firstNameField();
        field.shouldBe(visible, Duration.ofSeconds(10)).click();
        field.sendKeys(value);
        appiumDriver.hideKeyboard();
    }

    @Step("Ввожу значение в поле 'Отчество'")
    public void typeSecondName(String value) {
        waitUntilLoaded();
        SelenideElement field = secondNameField();
        field.shouldBe(visible, Duration.ofSeconds(10)).click();
        field.sendKeys(value);
        appiumDriver.hideKeyboard();
    }

    @Step("Ввожу значение в поле 'Email'")
    public void typeEmail(String value) {
        waitUntilLoaded();
        SelenideElement field = emailField();
        field.shouldBe(visible, Duration.ofSeconds(10)).click();
        field.sendKeys(value);
        appiumDriver.hideKeyboard();
    }

    @Step("Ввожу значение в поле 'Телефон'")
    public void typePhone(String value) {
        waitUntilLoaded();

        SelenideElement field = phoneField();
        field.shouldBe(visible, Duration.ofSeconds(10)).click();
        field.sendKeys(value);
        appiumDriver.hideKeyboard();
    }

    private SelenideElement scrollToByClassAndDesc(String className, String desc) {
        String safeDesc = desc.replace("\"", "\\\"");
        String ui =
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".setAsVerticalList()"
                        + ".setMaxSearchSwipes(24)"
                        + ".scrollIntoView(new UiSelector()"
                        + ".className(\"" + className + "\")"
                        + ".description(\"" + safeDesc + "\"))";
        return $(MobileBy.AndroidUIAutomator(ui));
    }

    @Step("Прокручиваю до кнопки 'Сгенерировать'")
    public SelenideElement scrollToGenerateButton() {
        return scrollToByClassAndDesc("android.widget.Button", "Сгенерировать")
                .shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Прокручиваю и нажимаю 'Сгенерировать'")
    public void scrollToAndClickGenerate() {
        scrollToGenerateButton().click();
    }

    @Step("Заполняю данные для выпуска гостевого пропуска")
    public void fillingDataForTheGuestPass(
            String lastNameValue,
            String firstNameValue,
            String secondNameValue,
            String emailValue,
            String phoneValue,
            int days) {
        typeLastName(lastNameValue);
        typeFirstName(firstNameValue);
        typeSecondName(secondNameValue);
        typeEmail(emailValue);
        typePhone(phoneValue);
        chooseAndSaveRangeFromToday(days);
        scrollToAndClickGenerate();
    }

    // ====== Работа с календарём (диапазон дат) ======
    @Step("Открываю окно выбора диапазона дат")
    public QrGuestPassPageBase openDatePicker() {
        dateRangeField().shouldBe(visible, Duration.ofSeconds(10)).click();
        selectDateRangeWindow().shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    // ячейка дня по content-desc, например "26 августа 2025 г."
    private SelenideElement dayCell(LocalDate date) {
        String desc = date.format(A11Y);
        String dayStr = desc.replaceFirst("\\..*$", "");
        return $(MobileBy.xpath("(//android.view.View[contains(@content-desc, '" + dayStr + "')])[1]"));
    }

    @Step("Выбираю дату: {date}")
    public QrGuestPassPageBase selectDate(LocalDate date) {
        dayCell(date).shouldBe(visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Выбираю диапазон дат: с {start} на {days} дн.")
    public QrGuestPassPageBase selectRange(LocalDate start, int days) {
        int d = Math.max(1, days);
        LocalDate end = start.plusDays(d - 1);
        selectDate(start);
        selectDate(end);
        return this;
    }

    @Step("Сохраняю выбранный диапазон")
    public void saveDateRange() {
        saveButton().shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Выбираю диапазон на {days} дн. от сегодня и сохраняю")
    public void chooseAndSaveRangeFromToday(int days) {
        openDatePicker();
        selectRange(LocalDate.now(), days);
        saveDateRange();
    }
}
