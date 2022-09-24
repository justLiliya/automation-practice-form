package com.liliapaper.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    private SelenideElement table = $(".table-responsive table");
    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public ResultTableComponent checkVisible() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public ResultTableComponent checkResult(String name, String lastName, String userMail, String userNumber, String month, String year, String subjects, String currentAddress, String state, String city, String gender, String day, String hobb) {
        table.shouldHave(text(name),
                (text(lastName)),
                (text(userMail)),
                (text(gender)),
                (text(userNumber)),
                (text(day + " " + month + "," + year)),
                (text(subjects)),
                (text(hobb)),
                (text("Photo.png")),
                (text(currentAddress)),
                (text(state + " " + city)));
        return this;
    }
}
