package com.liliapaper.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.liliapaper.helpers.Attach;
import com.liliapaper.pages.RegistrationFormPage;
import com.liliapaper.pages.components.WebSteps;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.nio.charset.StandardCharsets;

public class AutomationPracticeFormTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();
    WebSteps steps = new WebSteps();

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.holdBrowserOpen = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void fillAutomationPracticeFormTest() {
        //заполнение полей
        steps.openAndFillForm();
        steps.attachScreenshot();//пример вызова скриншота в тесте
        //проверка полей во всплывающем окне
        steps.checkForm();
        steps.attachScreenshot();
        //закрытие итоговой формы
        steps.closeForm();
        steps.attachScreenshot();
        Allure.getLifecycle().addAttachment(//пример добавления скриншота в тесте
                "Исходники страницы",
                "text/html",
                "html",
                WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
        );
    }


    @AfterEach
    void AddAttachments() {
        Attach.screenshotAs("Last screenshots");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
