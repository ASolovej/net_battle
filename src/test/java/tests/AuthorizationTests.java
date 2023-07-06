package tests;

import data.AuthorizationTestsData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;


@Tag("UI")
public class AuthorizationTests extends BaseTest {
    AuthorizationTestsData data = new AuthorizationTestsData();

    @DisplayName("Проверка видимости кнопок авторизации")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void loginButtonsTest() {
        new LoginPage()
                .openBattleNet()
                .buttonGoogleVisible()
                .buttonFacebookVisible()
                .buttonPlayStationVisible()
                .buttonNintendoVisible()
                .buttonXboxVisible()
                .buttonAppleVisible();
    }

    @DisplayName("Проверка авторизации с помощью ввода почты и пароля")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void authorizationTest() {
        new LoginPage()
                .openBattleNet()
                .setEmail(data.getEmail())
                .setPassword(data.getPassword())
                .clickButtonLogIn()
                .checkErrorAuthorization();
    }

    @DisplayName("Проверка присутствия сыылки 'Вы не можете войти?'")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginSupportTest() {
        new LoginPage()
                .openBattleNet()
                .checkStringLoginSupport();
    }

}
