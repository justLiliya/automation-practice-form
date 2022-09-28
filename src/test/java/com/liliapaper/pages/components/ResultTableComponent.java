package com.liliapaper.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    private SelenideElement table = $(".table-responsive table");
    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public ResultTableComponent checkVisible() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public ResultTableComponent checkResult(String result, String sample) {
        table.$(byText(result))
                .parent().shouldHave(text(sample));
        return this;
    }
}
