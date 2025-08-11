package android;

import baseUtils.Data;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.visible;

@DisplayName("Авторизация: Android")
public class AuthorizationTest extends BaseAndroidTest {

    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
    }

    @Test
    @DisplayName("Успешный вход по логину/паролю")
    public void successAuthorization() throws InterruptedException {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                        Data.UserTypes.DEFAULT_USER.passwordValidValue(),
                        false
                );

        // Предпочтительный для диплома стиль: проверка через шаг страницы
        mainPageAndroid.mainPageHeaderShouldBeVisible();
    }

    @Test
    @DisplayName("Ошибка при входе с неверным паролем")
    public void incorrectAuthorization() throws InterruptedException {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                        Data.UserTypes.DEFAULT_USER.passwordInvalidValue(),
                        true
                );

        loginPageAndroid.incorrectDataErrorMessage().shouldBe(visible);
    }

    @Test
    @DisplayName("Повторный вход по PIN после перезапуска приложения")
    public void successAuthorizationByPin() throws InterruptedException {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                        Data.UserTypes.DEFAULT_USER.passwordValidValue(),
                        false
                );

        mainPageAndroid.closeAndRunApp();      // app.id можно переопределить через -Dapp.id
        inputPinPageAndroid.clickNum1();
        mainPageAndroid.waitUntilLoaded().mainPageHeaderShouldBeVisible();
    }

    @Test
    @DisplayName("Неверный PIN — остаёмся на экране ввода PIN")
    public void incorrectAuthorizationByPin() throws InterruptedException {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                        Data.UserTypes.DEFAULT_USER.passwordValidValue(),
                        false
                );

        mainPageAndroid.closeAndRunApp();
        inputPinPageAndroid.clickNum2();

        inputPinPageAndroid.inputPinHeader().shouldBe(visible);
    }

    @Test
    @DisplayName("Вход по PIN без интернета — вижу модалку о проблемах с сетью")
    public void authorizationByPinWithoutInternet() throws InterruptedException {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                        Data.UserTypes.DEFAULT_USER.passwordValidValue(),
                        false
                );

        mainPageAndroid.closeAndRunApp();
        mainPageAndroid.toggleMobileData(); // выключили/включили мобильные данные
        inputPinPageAndroid.clickNum1();

        SelenideElement modal = inputPinPageAndroid
                .somethingWrongWithInternetModalWindow()
                .shouldBe(visible);

        mainPageAndroid.toggleMobileData(); // вернули сеть

        modal.shouldBe(visible); // финальная проверка состояния модалки
    }
}
