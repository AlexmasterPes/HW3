package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork {

        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.pageLoadStrategy = "eager";
        }

        @Test
        void fillFormTest() {

            // страница
            open("/automation-practice-form");

            //реклама
            executeJavaScript("$('footer').remove();");
            executeJavaScript("$('#fixedban').remove();");

            //Имя
            $("#firstName").setValue("Alexander");

            //Фамилия
            $("#lastName").setValue("Pesegov");

            //Пол
            $("#genterWrapper").$(byText("Male")).click();

            //Почта
            $("#userEmail").setValue("metallurgkras@mail.ru");

            //Телефон
            $("#userNumber").setValue("9632614307");

            //Дата Рождения
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("October");
            $(".react-datepicker__year-select").selectOption("1994");
            $(".react-datepicker__day--015").click();

            //Предмет
            $("#subjectsInput").setValue("Economics").pressEnter();

            //Хобби
            $("#hobbiesWrapper").$(byText("Sports")).click();

            //Изображение
            $("#uploadPicture").uploadFromClasspath("таблица.jpg");

            //Адрес
            $("#currentAddress").setValue("Красноярск, Урицкого 31");

            //Штат и Город
            $("#state").click();
            $("#react-select-3-input").setValue("NCR").pressEnter();
            $("#city").click();
            $("#react-select-4-input").setValue("Delhi").pressEnter();

            //Отправка
            $("#submit").click();


            //Проверка
            $(".table-responsive").shouldHave(text("Alexander"));
            $(".table-responsive").shouldHave(text("Pesegov"));
            $(".table-responsive").shouldHave(text("metallurgkras@mail.ru"));
            $(".table-responsive").shouldHave(text("Male"));
            $(".table-responsive").shouldHave(text("9632614307"));
            $(".table-responsive").shouldHave(text("15 October,1994"));
            $(".table-responsive").shouldHave(text("Economics"));
            $(".table-responsive").shouldHave(text("Sports"));
            $(".table-responsive").shouldHave(text("таблица.jpg"));
            $(".table-responsive").shouldHave(text("Красноярск, Урицкого 31"));
            $(".table-responsive").shouldHave(text("NCR"));
            $(".table-responsive").shouldHave(text("Delhi"));
        }
    }
