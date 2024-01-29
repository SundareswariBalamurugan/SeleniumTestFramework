package com.stepdefs;

import io.cucumber.java.en.Given;
import pages.TestFrameworkPage;

public class TestFrameworkStepDefs {

    TestFrameworkPage testPage = new TestFrameworkPage();

    @Given("User launches the {string} site")
    public void user_launches_the_site(String url) {
        testPage.launchUrl(url);
    }
}
