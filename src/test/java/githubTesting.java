import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class githubTesting {

    @Test
    void githubSelenideTesting() {
        Configuration.baseUrl="https://github.com/";
        open("selenide/selenide");

        $("[data-hotkey='g w']").click();
        assert (url().equals(Configuration.baseUrl + "selenide/selenide/wiki"));

        $(".markdown-body").shouldHave(text("Soft assertions"));
        $(byText("SoftAssertions")).click();
        assert (url().equals(Configuration.baseUrl + "selenide/selenide/wiki/SoftAssertions"));

        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
        sleep(2000);
    }
}
