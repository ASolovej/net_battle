package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private static final SelenideElement
            buttonGoogleCss = $("#google"),
            buttonFaceBookCss = $("#facebook"),
            buttonAppleCss = $("#apple"),
            buttonXboxCss = $("#live"),
            buttonPlayStationCss = $("#psn"),
            buttonNintendoCss = $("#nintendo");

    private static final SelenideElement
            buttonGoogleXpath = $x("//button[@id='google']"),
            buttonFaceBookXpath = $x("//button[@id='facebook']"),
            buttonAppleXpath = $x("//button[@id='apple']"),
            buttonXboxXpath = $x("//button[@id='live']"),
            buttonPlayStationXpath = $x("//button[@id='psn']"),
            buttonNintendoXpath = $x("//button[@id='nintendo']");

    private static final SelenideElement
            emailFieldCss = $("#accountName"),
            passwordFieldCss = $("#password");

    private static final SelenideElement
            emailFieldXpath = $x("//input[@id='accountName']"),
            passwordFieldXpath = $x("//input[@id='password']");

    private static final SelenideElement buttonLogInCss = $("#submit");
    private static final SelenideElement buttonLogInXpath = $x("//button[@id='submit']");
    private static final SelenideElement errorAuthorizationCss = $x("//span[contains(@class, 'error-helper-account')]");

    private static final SelenideElement
            loginSupportCss = $("#loginSupport"), loginSupport = $x("//a[@id='loginSupport']");

    @Step("Открыть страницу авторизации сайта battle.net")
    public LoginPage openBattleNet() {
        open("/");
        return this;
    }

    @Step("Проверить видимость кнопки авторизации через Google")
    public LoginPage buttonGoogleVisible() {
        buttonGoogleCss.shouldBe(Condition.visible);
        return this;
    }
    @Step("Проверить видимость кнопки авторизации через Facebook")
    public LoginPage buttonFacebookVisible() {
        buttonFaceBookCss.shouldBe(Condition.visible);
        return this;
    }
    @Step("Проверить видимость кнопки авторизации через Apple")
    public LoginPage buttonAppleVisible() {
        buttonAppleCss.shouldBe(Condition.visible);
        return this;
    }
    @Step("Проверить видимость кнопки авторизации через Xbox")
    public LoginPage buttonXboxVisible() {
        buttonXboxCss.shouldBe(Condition.visible);
        return this;
    }
    @Step("Проверить видимость кнопки авторизации через PlayStation")
    public LoginPage buttonPlayStationVisible() {
        buttonPlayStationCss.shouldBe(Condition.visible);
        return this;
    }
    @Step("Проверить видимость кнопки авторизации через Nintendo")
    public LoginPage buttonNintendoVisible() {
        buttonNintendoCss.shouldBe(Condition.visible);
        return this;
    }
    @Step("Ввести почту {email}")
    public LoginPage setEmail(String email) {
        emailFieldXpath.setValue(email);
        return this;
    }
    @Step("Ввести пароль {password}")
    public LoginPage setPassword(String password) {
        passwordFieldXpath.setValue(password);
        return this;
    }
    @Step("Нажать кнопку 'Авторизоваться'")
    public  LoginPage clickButtonLogIn() {
        buttonLogInXpath.click();
        return this;
    }
    @Step("Проверить, что появилась ошибка: 'Необходимо указать корректное имя пользователя.'")
    public LoginPage checkErrorAuthorization() {
        errorAuthorizationCss.shouldHave(Condition.text("Необходимо указать корректное имя пользователя"));
        return this;
    }
    @Step("Проверить, что на странице присутствует ссылка: 'Вы не можете войти?'")
    public LoginPage checkStringLoginSupport() {
        loginSupport.shouldHave(Condition.text("Вы не можете войти?"));
        return this;
    }
}
