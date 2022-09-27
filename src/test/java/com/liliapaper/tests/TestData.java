package com.liliapaper.tests;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

public class TestData {

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
}
