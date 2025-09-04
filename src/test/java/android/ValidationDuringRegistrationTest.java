package android;

import baseUtils.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationDuringRegistrationTest extends BaseAndroidTest {
    String phone;

    @Override
    @BeforeEach
    public void initPages() throws Exception {
        super.initPages();
        mainPageAndroid.openProfile();
        loginPageAndroid.clickToCreateNewAccountButton();

    }

    @Test
    @DisplayName("Валидация при регистрации - отображение ошибки 'Данный номер уже зарегистрирован'")
    public void validationAlreadyRegisteredPhoneErrorMessage() {
        phone = Data.UserTypes.APPROVED_EMPLOYEE.phoneValidValue();
        registrationPageAndroid.successTypePhoneNumber(phone);

        registrationPageAndroid.waitUntilLoadedAlreadyRegisteredPhoneMessage();
    }

    @Test
    @DisplayName("Валидация при регистрации - отображение ошибки 'Данный Email уже используется, пожалуйста, введите другой'")
    public void validationAlreadyRegisteredEmailErrorMessage() throws InterruptedException {
        phone = Data.UserTypes.FOR_VALIDATION_TEST_USER.phoneValidValue();
        registrationPageAndroid.successTypePhoneNumber(phone);
        otpPageAndroid.typeCorrectOtp();
        setPasswordPageAndroid.inputPassword(
                Data.UserTypes.FOR_VALIDATION_TEST_USER.passwordValidValue());
        setPersonalDataPageAndroid.typeAllDataForValidationTest(
                Data.UserTypes.FOR_VALIDATION_TEST_USER.userLastName(),
                Data.UserTypes.FOR_VALIDATION_TEST_USER.userFirstName(),
                Data.UserTypes.FOR_VALIDATION_TEST_USER.userSecondName(),
                Data.UserTypes.FOR_VALIDATION_TEST_USER.userEmail(),
                Data.SZ_A101_INN
        );

        registrationPageAndroid.waitUntilLoadedAlreadyRegisteredEmailMessage();
    }
}
