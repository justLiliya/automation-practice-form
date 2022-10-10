package com.liliapaper.pages.components;

import com.codeborne.selenide.WebDriverRunner;
import com.liliapaper.pages.RegistrationFormPage;
import com.liliapaper.helpers.TestData;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WebSteps {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();

    @Step("Открываем главную страницу и заполняем полную форму")
    public void openAndFillForm() {
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
    }

    @Step("Проверяем заполненную форму")
    public void checkForm() {
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
    }

    @Step("Закрываем форму")
    public void closeForm() {
        registrationFormPage.closeForm();
    }
    @Attachment(value = "Тут скриншотик", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
