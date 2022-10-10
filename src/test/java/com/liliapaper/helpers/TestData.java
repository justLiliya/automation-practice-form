package com.liliapaper.helpers;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

public class TestData {

    Faker faker = new Faker();
    public File file = new File("src/test/resources/Photo.png");
    public String name = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userNumber = RandomStringUtils.randomNumeric(10, 10);
    public String subjects = "Hindi";
    public String currentAddress = faker.address().streetAddress();
    public String userMail = faker.internet().emailAddress();
    public String gender = "Female";
    public String month = "January";
    public String year = "2000";
    public String day = "10";
    public String state = "Uttar Pradesh";
    public String city = "Agra";
    public String hostname = "/automation-practice-form";
    public String hobb = "Sports";
    public String fileName = "Photo.png";
    public String birthDay = day + " " + month + "," + year;
}
