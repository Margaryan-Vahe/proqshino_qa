package android;

import baseUtils.Data;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PassCreatingTest extends BaseAndroidTest {
    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
    }

    @Override
    @AfterEach
    public void tearDown() {
        myPassesPageAndroid.deactivatePass();
        super.tearDown();
    }

    @Test
    @DisplayName("Выпуск личного QR-пропуска: подтвержденный на ресепшене пользователь (Главная-Пропуск)")
    public void successCreatingPersonalQRPassBeingApprovedFromMainPage() throws Exception {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.APPROVED_USER.phoneValidValue(),
                        Data.UserTypes.APPROVED_USER.passwordValidValue(),
                        false
                );

        mainPageAndroid.openPassPage();
        passCreationMainPageAndroid.clickToPersonalPassButton();
        personalPassTypesPageAndroid.clickToQRPassButton();
        qrPassMainPageAndroid.requestPersonalQRPassBeingApproved();

        myPassesPageAndroid.checkQRActiveStatus();
    }

    @Test
    @DisplayName("Выпуск личного QR-пропуска: неподтвержденный на ресепшене пользователь (Главная-Пропуск)")
    public void successCreatingPersonalQRPassBeingNotApprovedFromMainPage() throws Exception {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.NOT_APPROVED_USER.phoneValidValue(),
                        Data.UserTypes.NOT_APPROVED_USER.passwordValidValue(),
                        false
                );

        mainPageAndroid.openPassPage();
        passCreationMainPageAndroid.clickToPersonalPassButton();
        personalPassTypesPageAndroid.clickToQRPassButton();
        qrPassMainPageAndroid.requestPersonalQRPassBeingNotApproved();

        myPassesPageAndroid.checkQROnApprovalStatus();
    }

    @Test
    @DisplayName("Выпуск личного QR-пропуска: подтвержденный на ресепшене пользователь (Профиль-Мои пропуска)")
    public void successCreatingPersonalQRPassBeingApprovedFromProfilePage() throws Exception {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.APPROVED_USER.phoneValidValue(),
                        Data.UserTypes.APPROVED_USER.passwordValidValue(),
                        false
                );

        mainPageAndroid.openProfile();
        profilePageAndroid.clickToMyPassesButton();
        myPassesPageAndroid.clickToCreateNewPersonalPassButton();
        personalPassTypesPageAndroid.clickToQRPassButton();
        qrPassMainPageAndroid.requestPersonalQRPassBeingApproved();

        myPassesPageAndroid.checkQRActiveStatus();
    }

    @Test
    @DisplayName("Выпуск личного QR-пропуска: неподтвержденный на ресепшене пользователь (Профиль-Мои пропуска)")
    public void successCreatingPersonalQRPassBeingNotApprovedFromProfilePage() throws Exception {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.NOT_APPROVED_USER.phoneValidValue(),
                        Data.UserTypes.NOT_APPROVED_USER.passwordValidValue(),
                        false
                );

        mainPageAndroid.openProfile();
        profilePageAndroid.clickToMyPassesButton();
        myPassesPageAndroid.clickToCreateNewPersonalPassButton();
        personalPassTypesPageAndroid.clickToQRPassButton();
        qrPassMainPageAndroid.requestPersonalQRPassBeingNotApproved();

        myPassesPageAndroid.checkQROnApprovalStatus();
    }

    @ParameterizedTest(name = "Выпуск гостевого QR-пропуска через Профиль-Мои пропуска: на {0} дн.")
    @ValueSource(ints = {2, 3})
    @DisplayName("Выпуск гостевого QR-пропуска (профиль → мои пропуска)")
    public void creatingGuestQRPassFromProfile(int days) throws Exception {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.APPROVED_USER.phoneValidValue(),
                        Data.UserTypes.APPROVED_USER.passwordValidValue(),
                        false
                );

        mainPageAndroid.openProfile();
        profilePageAndroid.clickToMyPassesButton();
        myPassesPageAndroid.clickToGuestTab();
        myPassesPageAndroid.clickToCreateNewGuestPassButton();
        guestPassTypesPageAndroid.clickToQRPassButton();

        qrGuestPassPageAndroid.fillingDataForTheGuestPass(
                "Test",
                "Test",
                "Test",
                "test@test.com",
                "79333333333",
                days
        );

        qrGuestPassPageAndroid.clickToMyPassesButton();
        myPassesPageAndroid.clickToGuestTab();
    }

}
