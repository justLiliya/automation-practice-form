package com.liliapaper.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.liliapaper.pages.RegistrationFormPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

public class AutomationPracticeFormTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();
    File file = new File("src/test/resources/Photo.png");
    String name = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userNumber = RandomStringUtils.randomNumeric(10, 10);
    String subjects = "Hindi";
    String currentAddress = faker.address().streetAddress();
    String userMail = faker.internet().emailAddress();
    String gender = "Female";
    String month = "January";
    String year = "2000";
    String day = "10";
    String state = "Uttar Pradesh";
    String city = "Agra";
    String hostname = "/automation-practice-form";
    String hobb = "Sports";

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void fillAutomationPracticeFormTest() {
        //заполнение полей
        registrationFormPage
                .openPage(hostname)
                .changeFirstAndLastName(name, lastName)
                .changeEmail(userMail)
                .changGender(gender)
                .setPhone(userNumber)
                .setBirthDate(day, month, year)
                .setHobbies(subjects, hobb)
                .loadPhoto(file)
                .setAddress(currentAddress, state, city)
                .submit();

        //проверка полей во всплывающем окне
        registrationFormPage
                .assertFormsfields(name, lastName, userMail, userNumber, month, year, subjects, currentAddress, state, city, gender, day, hobb);

        //закрытие итоговой формы
        registrationFormPage.closeForm();
    }
}
