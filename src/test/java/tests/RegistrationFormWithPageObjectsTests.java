package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjectsTests {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Alex";
    String lastName = "Bond";
    String userEmail = "alex@compani.com";
    String gender = "Other";
    String number = "1234567890";
    String subjects = "English";
    String hobbies = "Music";
    String address = "Rome";
    String state = "Uttar Pradesh";
    String city = "Agra";
    String day = "24";
    String month = "May";
    String year = "1984";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = " https://demoqa.com/";
        Configuration.browserSize = "1920x1080";

    }


    @Test
    void successFillTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setNumber(number)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .imgPicture()
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .Submit();


        registrationPage
                .checkTitle("Thanks for submitting the form")
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", gender)
                .checkForm("Mobile", number)
                .checkForm("Date of Birth", "24 May,1984")
                .checkForm("Subjects", subjects)
                .checkForm("Hobbies", hobbies)
                .checkForm("Picture", "mem1.jpg")
                .checkForm("Address", address)
                .checkForm("State and City", "Uttar Pradesh Agra")
                .CloseButton();


    }
}

