package com.liliapaper.pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    //Elements
    private SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            mail = $("#userEmail"),
            gend = $("#genterWrapper"),
            phone = $("#userNumber"),
            dateOfBirth =$("#dateOfBirthInput"),
            monthPicker = $(".react-datepicker__month-select"),
            yearPicker = $(".react-datepicker__year-select"),
            subj = $("#subjectsInput"),
            nobbies = $("#hobbiesWrapper"),
            photoLoader = $("#uploadPicture"),
            address = $("#currentAddress"),
            stateField = $("#state"),
            cityField = $("#city"),
            table = $(".table-responsive table"),
            closeButton = $("#closeLargeModal"),
            submitButton = $("#submit");


    //Actions
    public RegistrationFormPage openPage(String hostname) {
        open(hostname);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('fixedban').remove()");
        return this;
    }

    public RegistrationFormPage changeFirstAndLastName(String name, String last) {
        firstName.setValue(name);
        lastName.setValue(last);
        return this;
    }

    public RegistrationFormPage changeEmail(String userMail) {
        mail.setValue(userMail);
        return this;
    }

    public RegistrationFormPage changGender(String gender) {
        gend.$(byText(gender)).click();
        return this;
    }

    public RegistrationFormPage setPhone(String userNumber) {
        phone.setValue(userNumber);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateOfBirth.click();
        monthPicker.selectOption(month);
        yearPicker.selectOption(year);
        $(".react-datepicker__day--0"+day).click();
        return this;
    }

    public RegistrationFormPage setHobbies(String subjects, String hobb) {
        subj.setValue(subjects).pressEnter();
        nobbies.$(byText(hobb)).click();
        return this;
    }

    public RegistrationFormPage loadPhoto(File file) {
        photoLoader.uploadFile(file);
        return this;
    }

    public RegistrationFormPage setAddress(String currentAddress, String state, String city) {
        address.setValue(currentAddress);
        stateField.click();
        $(byText(state)).click();
        cityField.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationFormPage submit() {
        submitButton.shouldBe(visible).click();
        return this;
    }

    public void assertFormsfields(String name, String lastName, String userMail, String userNumber, String month, String year, String subjects, String currentAddress, String state, String city, String gender, String day, String hobb) {
        table.shouldHave(text(name),
                (text(lastName)),
                (text(userMail)),
                (text(gender)),
                (text(userNumber)),
                (text(day+" " + month + "," + year)),
                (text(subjects)),
                (text(hobb)),
                (text("Photo.png")),
                (text(currentAddress)),
                (text(state + " " + city)));
    }

    public void closeForm() {
        closeButton.click();
    }
}
