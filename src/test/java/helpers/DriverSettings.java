package helpers;

import com.codeborne.selenide.Configuration;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.Map;

public class DriverSettings {
    private WebDriverConfig config;
    public DriverSettings() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }
    public void configure() {
        Configuration.browserSize = config.getSize();
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getVersion();
        Configuration.baseUrl = "https://eu.account.battle.net/login/ru";
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        if (System.getProperty("env").equals("remote")) {
            Configuration.remote = config.getRemote() + "/wd/hub";
        }


        if (Configuration.browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars",
                    "disable-translate", "disable-notifications",
                    "disable-popup-blocking", "ignore-certificate-errors");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }

        Configuration.browserCapabilities = capabilities;
    }
}
