package android;

import baseUtils.Data;
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
}
