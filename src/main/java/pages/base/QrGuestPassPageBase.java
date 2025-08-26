package pages.base;

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

    // ====== Локаторы экрана ======
    public abstract SelenideElement pageHeader();
    public abstract SelenideElement lastNameField();
    public abstract SelenideElement firstNameField();
    public abstract SelenideElement secondNameField();
    public abstract SelenideElement emailField();
    public abstract SelenideElement phoneField();

    // Поле выбора диапазона дат (кликаем, чтобы открыть календарь)
    public abstract SelenideElement dateRangeField();
    // Корневой элемент окна выбора диапазона (по нему ждём открытие календаря)
    public abstract SelenideElement selectDateRangeWindow();
    // Кнопка "Сохранить" в календаре
    public abstract SelenideElement saveButton();
    // Кнопка "Сгенерировать" на форме (оставил как есть)
    public abstract SelenideElement generateButton();

    // ====== Формат даты как в content-desc у ячейки дня: "26 августа 2025 г." ======
    private static final Locale RU = new Locale("ru", "RU");
    private static final DateTimeFormatter A11Y = DateTimeFormatter.ofPattern("d MMMM yyyy 'г.'", RU);

    public QrGuestPassPageBase(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    // ====== Базовые методы ввода ======
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
    }

    @Step("Ввожу значение в поле 'Имя'")
    public void typeFirstName(String value) {
        waitUntilLoaded();
        SelenideElement field = firstNameField();
        field.shouldBe(visible, Duration.ofSeconds(10)).click();
        field.sendKeys(value);
    }

    @Step("Ввожу значение в поле 'Отчество'")
    public void typeSecondName(String value) {
        waitUntilLoaded();
        SelenideElement field = secondNameField();
        field.shouldBe(visible, Duration.ofSeconds(10)).click();
        field.sendKeys(value);
    }

    @Step("Ввожу значение в поле 'Email'")
    public void typeEmail(String value) {
        waitUntilLoaded();
        SelenideElement field = emailField();
        field.shouldBe(visible, Duration.ofSeconds(10)).click();
        field.sendKeys(value);
    }

    @Step("Ввожу значение в поле 'Телефон'")
    public void typePhone(String value) {
        waitUntilLoaded();
        SelenideElement field = phoneField();
        field.shouldBe(visible, Duration.ofSeconds(10)).click();
        field.sendKeys(value);
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
        generateButton().click();
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
        return $(MobileBy.AccessibilityId(desc));
    }

    // проскроллить до дня по description, если он не в видимой области
    private SelenideElement scrollToDay(LocalDate date) {
        String desc = date.format(A11Y).replace("\"", "\\\"");
        return $(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().description(\"" + desc + "\"))"
        ));
    }

    @Step("Выбираю дату: {date}")
    public QrGuestPassPageBase selectDate(LocalDate date) {
        if (!dayCell(date).exists()) {
            scrollToDay(date).shouldBe(visible, Duration.ofSeconds(10));
        }
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

    // ------- Готовые кейсы (сегодня как старт) -------
    @Step("Выбираю 1 день (сегодня)")
    public QrGuestPassPageBase selectOneDayFromToday() {
        return selectRange(LocalDate.now(), 1);
    }

    @Step("Выбираю 2 дня (сегодня и завтра)")
    public QrGuestPassPageBase selectTwoDaysFromToday() {
        return selectRange(LocalDate.now(), 2);
    }

    @Step("Выбираю 3 дня (сегодня +2)")
    public QrGuestPassPageBase selectThreeDaysFromToday() {
        return selectRange(LocalDate.now(), 3);
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
