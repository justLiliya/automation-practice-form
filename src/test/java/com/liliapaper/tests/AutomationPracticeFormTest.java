package com.liliapaper.tests;

import com.codeborne.selenide.Configuration;
import com.liliapaper.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormTest extends TestData {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

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
