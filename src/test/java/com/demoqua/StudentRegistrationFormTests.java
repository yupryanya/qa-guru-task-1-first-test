package com.demoqua;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        String firstName = "John";
        String lastName = "Doe";
        String dateOfBirthYear = "1989";
        String dateOfBirthMonth = "March";
        String dateOfBirthdayDay = "18";
        String userEmail = "testmail@testmail.test";
        String userPhoneNumber = "9876543210";
        String gender = "Male";
        String subject1 = "Maths";
        String subject2 = "English";
        String hobbie1 = "Music";
        String hobbie2 = "Sports";
        String currentAddress = "Gandhi Chowk Street, 10";
        String pictureFileFromClassPath = "empty.jpg";
        String stateName = "Uttar Pradesh";
        String cityName = "Agra";

        open("/automation-practice-form");
        open("/automation-practice-form");
        open("/automation-practice-form");

        //Name
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);

        //Email
        $("#userEmail").setValue(userEmail);

        //Gender
        $(byText(gender)).click();

        //Mobile
        $("#userNumber").setValue(userPhoneNumber);

        //Date of Birth
        //Calendar
        $("#dateOfBirthInput").click();
        //Year
        $(".react-datepicker__year-select").selectOption(dateOfBirthYear);
        $(".react-datepicker__year-select").click();
        //Month
        $(".react-datepicker__month-select").selectOption(dateOfBirthMonth);
        $(".react-datepicker__month-select").click();
        //Day
        String daySelector = "";
        if (dateOfBirthdayDay.length() < 2) {
            daySelector = ".react-datepicker__day.react-datepicker__day--00" + dateOfBirthdayDay;
        } else {
            daySelector = ".react-datepicker__day.react-datepicker__day--0" + dateOfBirthdayDay;
        }
        $(daySelector).click();

        //Subjects
        $("#subjectsInput").setValue(subject1);
        $("#subjectsInput").pressEnter(); //По Enter
        // $("#react-select-2-option-0").click(); //По первому совпадению

        $("#subjectsInput").setValue(subject2);
        $("#subjectsInput").pressEnter(); //По Enter
        //  $("#react-select-2-option-0").click();   //По первому совпадению

        //Hobbies
        $(byText(hobbie1)).click();
        $(byText(hobbie2)).click();

        //Picture
        $(byId("uploadPicture")).uploadFromClasspath(pictureFileFromClassPath);

        //Current Address
        $("#currentAddress").setValue(currentAddress);

        //State
        $("#react-select-3-input").sendKeys(stateName);
        $("#react-select-3-input").pressEnter();

        //City
        $("#react-select-4-input").setValue(cityName);
        $("#react-select-4-input").pressEnter();

        //Submit
        $("#submit").click();

        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(userPhoneNumber));
        $(".table-responsive").shouldHave(text(dateOfBirthdayDay + " "
                                            + dateOfBirthMonth + "," + dateOfBirthYear ));
        $(".table-responsive").shouldHave(text(subject1));
        $(".table-responsive").shouldHave(text(subject2));
        $(".table-responsive").shouldHave(text(hobbie1));
        $(".table-responsive").shouldHave(text(hobbie2));

        $(".table-responsive").shouldHave(text(pictureFileFromClassPath));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(stateName + " " + cityName));

    }

}

