package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    //locators
    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapperInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            uploadPicture = $("#uploadPicture"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityInput = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            titleInput = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive"),
            closeButton = $("#closeLargeModal");


    public RegistrationPage openPage() {
        open("automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    //actions
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genterWrapperInput.$(byText(gender)).click();
        return this;
    }


    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setNumber(String number) {
        numberInput.setValue(number);
        return this;
    }

    // $(".react-datepicker__year-select").selectOption(year);
    //  $(".react-datepicker__month-select").selectOption(month);
    //  $(".react-datepicker__day--0"+day+"").click();


    public RegistrationPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }


    public RegistrationPage setHobbies(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage uploadFile() {
        uploadPicture.uploadFromClasspath("mem1.jpg");
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.scrollTo().click();
        stateCityInput.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.scrollTo().click();
        stateCityInput.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    //проверка
    public RegistrationPage checkTitle(String title) {
        titleInput.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {

        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage clickCloseButton() {
        closeButton.click();
        return this;
    }

}
