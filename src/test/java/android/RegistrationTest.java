package android;

import baseUtils.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseAndroidTest {
    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
        loginPageAndroid.clickToCreateNewAccountButton();
    }

    @Test
    @DisplayName("Регистрация сотрудника: прямая регистрация")
    public void simpleEmployeeRegistration() throws InterruptedException {
        registrationPageAndroid.successTypePhoneNumber(Data.UserTypes.FOR_SIMPLE_REGISTRATION_EMPLOYEE.phoneValidValue());
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
