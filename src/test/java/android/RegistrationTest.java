package android;

import baseUtils.Data;
import baseUtils.DataBaseRequests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseAndroidTest {
    String phone;

    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
        loginPageAndroid.clickToCreateNewAccountButton();

    }

    @Override
    @AfterEach
    public void tearDown() {
        DataBaseRequests.deleteUserWithData(phone, false);
        super.tearDown();
    }

    @Test
    @DisplayName("Регистрация сотрудника: прямая регистрация")
    public void simpleEmployeeRegistration() throws InterruptedException {
        phone = Data.UserTypes.FOR_SIMPLE_REGISTRATION_EMPLOYEE.phoneValidValue();
        registrationPageAndroid.successTypePhoneNumber(phone);
        otpPageAndroid.typeCorrectOtp();
        setPasswordPageAndroid.inputPassword(
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_EMPLOYEE.passwordValidValue());
        setPersonalDataPageAndroid.typeAllData(
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_EMPLOYEE.userLastName(),
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_EMPLOYEE.userFirstName(),
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_EMPLOYEE.userSecondName(),
                Data.UserTypes.FOR_SIMPLE_REGISTRATION_EMPLOYEE.userEmail(),
                Data.SZ_A101_INN
        );

        setPinPageAndroid.clickNum1();
        repeatPinPageAndroid.clickNum1();
        bioConfirmationPageAndroid.clickToRefuseButton();
        inputPinPageAndroid.clickNum1();

        mainPageAndroid.waitUntilLoaded();
    }
}
