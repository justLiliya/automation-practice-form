package com.liliapaper;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {

    Faker faker = new Faker();
    File file = new File("src/test/resources/Photo.png");
    String name = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userNumber = RandomStringUtils.randomNumeric(10, 10);
    String subjects = "Hindi";
    String currentAddress = faker.address().streetAddress();
    String userMail = faker.internet().emailAddress();

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void fillAutomationPracticeFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('fixedban').remove()");

        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);

        $("#userEmail").setValue(userMail);

        $x("//label[@for='gender-radio-2']").click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2000");
        $("[class*='react-datepicker__day--010']").click();

        $("#subjectsInput").setValue(subjects).pressEnter();

        $("#hobbies-checkbox-1").parent().click();

        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Agra")).click();

        $("#submit").shouldBe(visible).click();

        //проверка полей во всплывающем окне
        $(".table-responsive table").shouldHave(text(name));
        $(".table-responsive table").shouldHave(text(lastName));
        $(".table-responsive table").shouldHave(text(userMail));
        $(".table-responsive table").shouldHave(text("Female"));
        $(".table-responsive table").shouldHave(text(userNumber));
        $(".table-responsive table").shouldHave(text("10 January,2000"));
        $(".table-responsive table").shouldHave(text(subjects));
        $(".table-responsive table").shouldHave(text("Sports"));
        $(".table-responsive table").shouldHave(text("Photo.png"));
        $(".table-responsive table").shouldHave(text(currentAddress));
        $(".table-responsive table").shouldHave(text("Uttar Pradesh Agra"));

        $("#closeLargeModal").click();
    }
}
