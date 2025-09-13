package mobile.android;

import baseUtils.Data;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
    public void successCreatingPersonalQRPassBeingApprovedFromMainPage() throws Exception {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.APPROVED_EMPLOYEE.phoneValidValue(),
                        Data.UserTypes.APPROVED_EMPLOYEE.passwordValidValue(),
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
    @Order(2)
    public void successCreatingPersonalQRPassBeingNotApprovedFromMainPage() throws Exception {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.NOT_APPROVED_EMPLOYEE.phoneValidValue(),
                        Data.UserTypes.NOT_APPROVED_EMPLOYEE.passwordValidValue(),
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
    @Order(3)
    public void successCreatingPersonalQRPassBeingApprovedFromProfilePage() throws Exception {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.APPROVED_EMPLOYEE.phoneValidValue(),
                        Data.UserTypes.APPROVED_EMPLOYEE.passwordValidValue(),
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
    @Order(4)
    public void successCreatingPersonalQRPassBeingNotApprovedFromProfilePage() throws Exception {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.NOT_APPROVED_EMPLOYEE.phoneValidValue(),
                        Data.UserTypes.NOT_APPROVED_EMPLOYEE.passwordValidValue(),
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
    @Order(5)
    public void creatingGuestQRPassFromProfile(int days) throws Exception {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.APPROVED_EMPLOYEE.phoneValidValue(),
                        Data.UserTypes.APPROVED_EMPLOYEE.passwordValidValue(),
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

    @ParameterizedTest(name = "Выпуск гостевого QR-пропуска через Главная-Пропуска: на {0} дн.")
    @ValueSource(ints = {2, 3})
    @DisplayName("Выпуск гостевого QR-пропуска (Главная → Пропуска)")
    @Order(6)
    public void creatingGuestQRPassFromMainPage(int days) throws Exception {
        loginPageAndroid
                .waitUntilLoaded()
                .login(
                        Data.UserTypes.APPROVED_EMPLOYEE.phoneValidValue(),
                        Data.UserTypes.APPROVED_EMPLOYEE.passwordValidValue(),
                        false
                );

        mainPageAndroid.openPassPage();
        passCreationMainPageAndroid.clickToGuestPassButton();
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
