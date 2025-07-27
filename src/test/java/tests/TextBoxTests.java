package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("AlexPes");
        $("#userEmail").setValue("metallurgkras@mail.ru");
        $("#currentAddress").setValue("ad1");
        $("#permanentAddress").setValue("ad2");
        $("#submit").click();

        $("#output #name").shouldHave(text("AlexPes"));
        $("#output #email").shouldHave(text("metallurgkras@mail.ru"));
        $("#output #currentAddress").shouldHave(text("ad1"));
        $("#output #permanentAddress").shouldHave(text("ad2"));
    }
}
