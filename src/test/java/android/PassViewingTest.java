package android;

import baseUtils.Data;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PassViewingTest extends BaseAndroidTest {
    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.WITH_QR_USER.phoneValidValue(),
                        Data.UserTypes.WITH_QR_USER.passwordValidValue(),
                        false
                );
    }

    @Test
    @DisplayName("Отображение личного QR-пропуска через Профиль-Мои пропуска")
    public void openQRPassCodeFromProfilePage() throws Exception {
        mainPageAndroid.openProfile();
        profilePageAndroid.clickToMyPassesButton();
        myPassesPageAndroid.openQR();
    }
}
