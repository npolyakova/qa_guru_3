import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class GithubTesting {

    @Test
    void githubSelenideTesting() {
        Configuration.baseUrl="https://github.com/";
        open("selenide/selenide");

        $("[data-hotkey='g w']").click();
        $("#user-content-welcome-to-the-selenide-wiki").shouldBe(visible);

        $(".markdown-body").shouldHave(text("Soft assertions"));
        $(byText("SoftAssertions")).click();
        assert (url().equals(Configuration.baseUrl + "selenide/selenide/wiki/SoftAssertions"));

        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
