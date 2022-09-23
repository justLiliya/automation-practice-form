package com.liliapaper.pages;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {


    public static void openPage(String hostname) {
        open(hostname);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('fixedban').remove()");
    }

    public void changeFirstAndLastName(String name, String lastName) {
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
    }

    public void changeEmail(String userMail) {
        $("#userEmail").setValue(userMail);
    }

    public void changGender() {
        $x("//label[@for='gender-radio-2']").click();
    }

    public void setPhone(String userNumber) {
        $("#userNumber").setValue(userNumber);
    }

    public void setBirthDate(String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $("[class*='react-datepicker__day--010']").click();
    }

    public void setHobbies(String subjects) {
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbies-checkbox-1").parent().click();
    }

    public void loadPhoto(File file) {
        $("#uploadPicture").uploadFile(file);
    }

    public void setAddress(String currentAddress, String state, String city) {
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
    }

    public void submit() {
        $("#submit").shouldBe(visible).click();
    }

    public void assertFormsfields(String name, String lastName, String userMail, String userNumber, String month, String year, String subjects, String currentAddress, String state, String city) {
        $(".table-responsive table").shouldHave(text(name),
                (text(lastName)),
                (text(userMail)),
                (text("Female")),
                (text(userNumber)),
                (text("10 " + month + "," + year)),
                (text(subjects)),
                (text("Sports")),
                (text("Photo.png")),
                (text(currentAddress)),
                (text(state + " " + city)));
    }

    public void closeForm() {
        $("#closeLargeModal").click();
    }
}
