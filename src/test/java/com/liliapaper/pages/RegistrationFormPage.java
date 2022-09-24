package com.liliapaper.pages;

import com.codeborne.selenide.SelenideElement;
import com.liliapaper.pages.components.AddressComponent;
import com.liliapaper.pages.components.CalendComponent;
import com.liliapaper.pages.components.ResultTableComponent;
import com.liliapaper.pages.components.UserComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    //Used components
    CalendComponent calendComponent = new CalendComponent();
    UserComponent userComponent = new UserComponent();
    AddressComponent addressComponent = new AddressComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    //Elements
    private SelenideElement
            mail = $("#userEmail"),
            gend = $("#genterWrapper"),
            phone = $("#userNumber"),
            subj = $("#subjectsInput"),
            nobbies = $("#hobbiesWrapper"),
            photoLoader = $("#uploadPicture"),
            address = $("#currentAddress"),
            stateField = $("#state"),
            cityField = $("#city"),
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
        userComponent.setUser(name, last);
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
        calendComponent.setDate(day, month, year);
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
        addressComponent.setAddr(currentAddress, state, city);
        return this;
    }

    public RegistrationFormPage submit() {
        submitButton.shouldBe(visible).click();
        return this;
    }

    public void assertFormsfields(String name, String lastName, String userMail, String userNumber, String month, String year, String subjects, String currentAddress, String state, String city, String gender, String day, String hobb) {
        resultTableComponent.checkResult(name, lastName, userMail, userNumber, month, year, subjects, currentAddress, state, city, gender, day, hobb);
    }

    public void closeForm() {
        closeButton.click();
    }
}
