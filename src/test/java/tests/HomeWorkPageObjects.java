package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class HomeWorkPageObjects extends tests.TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Alexander")
                .setLastName("Pesegov")
                .setEmail("metallurgkras@mail.ru")
                .setGender("Male")
                .setUserNumber("9632614307")
                .setDateOfBirth("15", "October", "1994")
                .setSubjects("Economics")
                .setHobbies("Sports")
                .setUploadPicture("таблица.jpg")
                .setCurrentAddress("Красноярск, Урицкого 31")
                .setStateDropdown()
                .setStateCityWrapper("NCR")
                .setCityDropdown()
                .setStateCityWrapper("Delhi")
                .setSubmit()
                .setModalDialog()
                .checkResult ("Student Name", "Alexander Pesegov")
                .checkResult ("Student Email", "metallurgkras@mail.ru")
                .checkResult ("Gender", "Male")
                .checkResult ("Mobile", "9632614307")
                .checkResult ("Date of Birth", "15 October,1994")
                .checkResult ("Subjects", "Economics")
                .checkResult ("Hobbies", "Sports")
                .checkResult ("Picture", "таблица.jpg")
                .checkResult ("Address", "Красноярск, Урицкого 31")
                .checkResult ("State and City", "NCR Delhi")
                .checkResult ("Picture", "таблица.jpg")
                .closeModal();
    }

    @Test
    void minRequired() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Alexander")
                .setLastName("Pesegov")
                .setGender("Male")
                .setUserNumber("9632614307")
                .setDateOfBirth("15", "October", "1994")
                .setSubmit()
                .setModalDialog()
                .checkResult ("Student Name", "Alexander Pesegov")
                .checkResult ("Gender", "Male")
                .checkResult ("Mobile", "9632614307")
                .checkResult ("Date of Birth", "15 October,1994")
                .closeModal();
    }

    @Test
    void negativeTest() {
        registrationPage.openPage()
                .removeBanners()
                // поле LastName пустое
                .setFirstName("Alexander")
                .setGender("Male")
                .setUserNumber("9632614307")
                .setDateOfBirth("15", "October", "1994")
                .setSubmit()
                .getModalDialog();

    }
}