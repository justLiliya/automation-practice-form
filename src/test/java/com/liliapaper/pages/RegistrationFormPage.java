package com.liliapaper.pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    //Elements
    private SelenideElement firstName = $("#firstName");
    private SelenideElement lastName = $("#lastName");

    private SelenideElement mail = $("#userEmail");

    private SelenideElement gend = $("#genterWrapper");

    private SelenideElement phone = $("#userNumber");

    private SelenideElement dateOfBirth =$("#dateOfBirthInput");

    private SelenideElement monthPicker = $(".react-datepicker__month-select");

    private SelenideElement yearPicker = $(".react-datepicker__year-select");

    private SelenideElement subj = $("#subjectsInput");
    private SelenideElement nobbies = $("#hobbiesWrapper");

    private SelenideElement photoLoader = $("#uploadPicture");

    private SelenideElement address = $("#currentAddress");
    private SelenideElement stateField = $("#state");
    private SelenideElement cityField = $("#city");

    private SelenideElement table = $(".table-responsive table");

    private SelenideElement closeButton = $("#closeLargeModal");

    private SelenideElement submitButton = $("#submit");


    //Actions
    public static void openPage(String hostname) {
        open(hostname);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('fixedban').remove()");
    }

    public void changeFirstAndLastName(String name, String last) {
        firstName.setValue(name);
        lastName.setValue(last);
    }

    public void changeEmail(String userMail) {
        mail.setValue(userMail);
    }

    public void changGender(String gender) {
        gend.$(byText(gender)).click();
    }

    public void setPhone(String userNumber) {
        phone.setValue(userNumber);
    }

    public void setBirthDate(String day, String month, String year) {
        dateOfBirth.click();
        monthPicker.selectOption(month);
        yearPicker.selectOption(year);
        $(".react-datepicker__day--0"+day).click();
    }

    public void setHobbies(String subjects, String hobb) {
        subj.setValue(subjects).pressEnter();
        nobbies.$(byText(hobb)).click();
    }

    public void loadPhoto(File file) {
        photoLoader.uploadFile(file);
    }

    public void setAddress(String currentAddress, String state, String city) {
        address.setValue(currentAddress);
        stateField.click();
        $(byText(state)).click();
        cityField.click();
        $(byText(city)).click();
    }

    public void submit() {
        submitButton.shouldBe(visible).click();
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
