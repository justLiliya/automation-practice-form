package com.liliapaper.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UserComponent {

    private SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName");

    public UserComponent setUser(String name, String last){
        firstName.setValue(name);
        lastName.setValue(last);
        return this;
    }

}
