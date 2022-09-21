package com.liliapaper;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {

    Faker faker = new Faker();
    File file = new File("src/test/resources/Photo.png");
    String name = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userNumber = RandomStringUtils.randomNumeric(10, 10);
    String subjects = faker.artist().name();
    String currentAddress = faker.address().streetAddress();

    {
        try {
            if (file.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void fillAutomationPracticeFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("someMail@gmail.com");
        $x("//label[@for='gender-radio-2']").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--010:not(.react-datepicker__day--selected").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText("Sport")).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Agra")).click();
        $("#submit").click();

        //проверка полей во всплывающем окне
        $(".table-responsive table").shouldHave(text(name));
        $(".table-responsive table").shouldHave(text(lastName));
        $(".table-responsive table").shouldHave(text("someMail@gmail.com"));
        $(".table-responsive table").shouldHave(text("Female"));
        $(".table-responsive table").shouldHave(text(userNumber));
        $(".table-responsive table").shouldHave(text("10 January,2000"));
        $(".table-responsive table").shouldHave(text(subjects));
        $(".table-responsive table").shouldHave(text("Sports"));
        $(".table-responsive table").shouldHave(text("Photo.png"));
        $(".table-responsive table").shouldHave(text("currentAddress"));
        $(".table-responsive table").shouldHave(text("Uttar Pradesh Agra"));

        $("#closeLargeModal").click();
    }

    public void tearDown() {
        file.delete();
    }
}
