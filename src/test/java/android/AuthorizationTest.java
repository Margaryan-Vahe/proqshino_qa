package android;

import baseUtils.Data;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthorizationTest extends BaseAndroidTest {

    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
    }

    @Test
    public void successAuthorization() throws InterruptedException {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                        Data.UserTypes.DEFAULT_USER.passwordValidValue(),
                false);

                assertTrue(
                mainPageAndroid.mainPageHeader().is(visible),
                "Ожидался видимый заголовок главной страницы после успешного входа"  // или: main.mainPageHeaderShouldBeVisible()
        );
    }

    @Test
    public void incorrectAuthorization() throws InterruptedException {
        loginPageAndroid.login(Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                Data.UserTypes.DEFAULT_USER.passwordInvalidValue(),
                true);

                assertTrue(loginPageAndroid
                                .incorrectDataErrorMessage()
                                .is(visible),
                "Ожидался текст ошибки");
    }

    @Test
    public void successAuthorizationByPin() throws InterruptedException {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                        Data.UserTypes.DEFAULT_USER.passwordValidValue(),
                        false);

        mainPageAndroid.closeAndRunApp();
        inputPinPageAndroid.clickNum1();
        mainPageAndroid.waitUntilLoaded();

        assertTrue(
                mainPageAndroid.mainPageHeader().is(visible),
                "Ожидался видимый заголовок главной страницы после успешного входа"  // или: main.mainPageHeaderShouldBeVisible()
        );
    }

    @Test
    public void incorrectAuthorizationByPin() throws InterruptedException {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                        Data.UserTypes.DEFAULT_USER.passwordValidValue(),
                        false);

        mainPageAndroid.closeAndRunApp();
        inputPinPageAndroid.clickNum2();

        assertTrue(
                inputPinPageAndroid.inputPinHeader().is(visible),
                "Ожидался видимый заголовок страницы ввода пин-кода"
        );
    }
    @Test
    public void authorizationByPinWithoutInternet() throws InterruptedException {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.DEFAULT_USER.phoneValidValue(),
                        Data.UserTypes.DEFAULT_USER.passwordValidValue(),
                        false);

        mainPageAndroid.closeAndRunApp();
        mainPageAndroid.turnInternet();
        inputPinPageAndroid.clickNum1();

        SelenideElement checkModalWindowIsVisible =
        inputPinPageAndroid.somethingWrongWithInternetModalWindow().shouldBe(visible);

        mainPageAndroid.turnInternet();

        assertTrue(
                checkModalWindowIsVisible.is(visible),
                "Ожидалось отображение модального окна проблем с интернетом"
        );
    }
}
