package com.liliapaper.tests;

import com.codeborne.selenide.Configuration;
import com.liliapaper.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void fillAutomationPracticeFormTest() {
        //заполнение полей
        registrationFormPage
                .openPage(testData.hostname)
                .changeFirstAndLastName(testData.name, testData.lastName)
                .changeEmail(testData.userMail)
                .changGender(testData.gender)
                .setPhone(testData.userNumber)
                .setBirthDate(testData.day, testData.month, testData.year)
                .setHobbies(testData.subjects, testData.hobb)
                .loadPhoto(testData.file)
                .setAddress(testData.currentAddress, testData.state, testData.city)
                .submit();

        //проверка полей во всплывающем окне
        registrationFormPage
                .assertFormsfields("Student Name", testData.name + " " + testData.lastName)
                .assertFormsfields("Student Email", testData.userMail)
                .assertFormsfields("Gender", testData.gender)
                .assertFormsfields("Mobile", testData.userNumber)
                .assertFormsfields("Date of Birth", testData.birthDay)
                .assertFormsfields("Subjects", testData.subjects)
                .assertFormsfields("Hobbies", testData.hobb)
                .assertFormsfields("Picture", testData.fileName)
                .assertFormsfields("Address", testData.currentAddress)
                .assertFormsfields("State and City", testData.state + " " + testData.city);


        //закрытие итоговой формы
        registrationFormPage.closeForm();
    }
}
