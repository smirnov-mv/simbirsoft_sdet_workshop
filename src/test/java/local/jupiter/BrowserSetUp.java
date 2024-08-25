package local.jupiter;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class BrowserSetUp implements BeforeEachCallback {
    private static final String BROWSER_SIZE = "1920x1080";
    private final Logger LOGGER = getLogger(getClass());

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        LOGGER.info("Set up browser");
        Configuration.browser = Browsers.CHROME;
        Configuration.browserSize = BROWSER_SIZE;
        Configuration.pageLoadStrategy = "eager";
    }
}
