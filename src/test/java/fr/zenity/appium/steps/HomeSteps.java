package fr.zenity.appium.steps;

import io.cucumber.java8.En;

public class HomeSteps implements En {

    public HomeSteps() {

    Given("^user is on the home page$",() -> {
        System.out.println("wassim");
    });

    /*
    When("^user enters his \"([^\"]*)\" and his \"([^\"]*)\"$",(String mail, String password) -> {
        System.out.println("user enters his <mail> and his <password>");
    });
     */

        When("^user enters his",() -> {
            System.out.println("user enters his <mail> and his <password>");
        });

    Then("^user should be logged in$",() -> {
        System.out.println("user should be logged in");
    });

}
}
