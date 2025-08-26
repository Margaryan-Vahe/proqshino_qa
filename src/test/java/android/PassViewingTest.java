package android;

import baseUtils.Data;
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
    public void openQRPassCodeFromProfilePage() {
        mainPageAndroid.openProfile();
        profilePageAndroid.clickToMyPassesButton();
        myPassesPageAndroid.openQR();
    }
    @Test
    @DisplayName("Отображение личного QR-пропуска через Главная-Пропуск-Мои пропуска")
    public void openQRPassCodeFromPassPage() {
        mainPageAndroid.openPassPage();
        passCreationMainPageAndroid.clickMyPassesButton();
        myPassesPageAndroid.openQR();
    }
    @Test
    @DisplayName("Отображение личного QR-пропуска через Главную страницу")
    public void openQRPassCodeFromMainPage() {
        mainPageAndroid.openQR();
    }
}
