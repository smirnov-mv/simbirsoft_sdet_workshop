package local.jupiter;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith({
        BrowserSetUp.class,
        TextReportExtension.class,
        AllureSelenideLogger.class
})
public @interface WebTest {
}