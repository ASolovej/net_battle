package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("size")
    @DefaultValue("1920x1080")
    String getSize();

    @Key("version")
    @DefaultValue("112")
    String getVersion();

    @Key("remote")
    String getRemote();
}
