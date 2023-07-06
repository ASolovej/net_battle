package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.AllureAttachments;
import helpers.DriverSettings;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

@Link(name = "battle.net", value = "https://eu.account.battle.net/login/ru/")
@Owner("Alexandr Solovyov")
public class BaseTest {

    @BeforeAll
    public static void setUp() {
        DriverSettings driverSettings = new DriverSettings();
        driverSettings.configure();
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

    @AfterEach
    void addAttachments() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        if (!Configuration.browser.equals("firefox")) {
            AllureAttachments.browserConsoleLogs();
        }
        AllureAttachments.addVideo();
    }
}
