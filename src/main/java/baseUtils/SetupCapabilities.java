package baseUtils;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

public class SetupCapabilities {
    public static boolean isEmulator = true;
    public static AppiumDriver<MobileElement> appiumDriver;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public void setUp() throws Exception {
        Map<String, String> data = null;
        try {
            InputStream inputStream = new FileInputStream("src/test/resources/settings.yaml");
            Yaml yaml = new Yaml();
            data = yaml.load(inputStream);
        } catch (Exception e) {
            logger.error("Ошибка при загрузке файла settings.yaml", e);
            throw new RuntimeException("Не удалось загрузить настройки из settings.yaml", e);
        }

        String os = data.get("OS");
        URL appiumServerUrl = new URL(data.get("APPIUM_SERVER"));

        appiumDriver = setDriver(appiumServerUrl, os);

        // привязываем AppiumDriver к Selenide
        WebDriverRunner.setWebDriver(appiumDriver);
    }

    @AfterEach
    public void tearDown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }

    public AppiumDriver<MobileElement> setDriver(URL appiumServerUrl, String os) throws Exception {

        if (os.equals("Android"))
            return new AndroidDriver<>(appiumServerUrl, androidCapabilities(isEmulator));
        else if (os.equals("iOS"))
            return new IOSDriver<>(appiumServerUrl, iOSCapabilities());
        else
            throw new Exception("APPIUM_OS variable not set or wrong value: " + os);
    }

    public DesiredCapabilities androidCapabilities(boolean isEmulator) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (isEmulator) {
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("avd", "Pixel_4a_API_30");
            capabilities.setCapability("autoAcceptAlerts", true);
            capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("app",("/Applications/app-release.apk"));
            capabilities.setCapability("appPackage", "ru.prokshino.prokshino");
            capabilities.setCapability("appActivity", "ru.prokshino.prokshino.MainActivity");
            capabilities.setCapability("fullReset", false);
            capabilities.setCapability("avdArgs", "-no-window");
            capabilities.setCapability("automationName", "UiAutomator2");
        } else {
            // capabilities для локального прогона тестов
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("deviceName", "5LGIDECAN7YDHQJZ");
            //"MVS4C20509001762"
            //"5LGIDECAN7YDHQJZ"
            capabilities.setCapability("appPackage", "ru.prokshino.prokshino");
            capabilities.setCapability("appActivity", "ru.prokshino.prokshino.MainActivity");
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("orientation", "PORTRAIT");
            capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);
        }
        return capabilities;
    }

    public DesiredCapabilities iOSCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "18.3");
        capabilities.setCapability("deviceName", "iPhone 16");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", ("/Applications/Runner.app"));
        capabilities.setCapability("autoGrantPermissions", true);
    //    capabilities.setCapability("fullReset", true);
    //    capabilities.setCapability("noReset", false);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("appium:autoDismissAlerts", true);
        capabilities.setCapability("appium:showXcodeLog", true);

        return capabilities;
    }
}

