package local.pages.practice_form.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalSubmittedTable {
    private final SelenideElement container = $("[role='document']");

    @Step("[Check] [{0}] должно иметь значение [{1}]")
    private void check(String fieldName, String expectedValue) {
        container
                .$(byText(fieldName))
                .ancestor("tr")
                .$("td", 1)
                .shouldHave(exactTextCaseSensitive(expectedValue));
    }

    @Step("[Check] Модалка с данными студента должна открыться")
    public ModalSubmittedTable shouldBeVisible() {
        container.shouldBe(visible);
        container.$("[id='example-modal-sizes-title-lg']").shouldHave(exactTextCaseSensitive("Thanks for submitting the form"));
        return this;
    }

    public ModalSubmittedTable shouldHaveName(String firstName, String lastname) {
        check("Student Name", "%s %s".formatted(firstName, lastname));
        return this;
    }

    public ModalSubmittedTable shouldHaveEmail(String email) {
        check("Student Email", email);
        return this;
    }

    public ModalSubmittedTable shouldHaveGender(Gender gender) {
        check("Gender", gender.value);
        return this;
    }

    public ModalSubmittedTable shouldHaveMobile(String mobileNumber) {
        check("Mobile", mobileNumber);
        return this;
    }

    public ModalSubmittedTable shouldHaveDateOfBirth(LocalDate dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH);
        String formattedDate = dateOfBirth.format(formatter);
        check("Date of Birth", formattedDate);
        return this;
    }

    public ModalSubmittedTable shouldHaveSubjects(String subject) {
        check("Subjects", subject);
        return this;
    }

    public ModalSubmittedTable checkPicture() {
        String pictureName = "Toolsqa.jpg";
        check("Picture", pictureName);
        return this;
    }

    public ModalSubmittedTable shouldHaveAddress(String address) {
        check("Address", address);
        return this;
    }

    public ModalSubmittedTable shouldHaveStateAndCity(StateWithCity state, String city) {
        String expectedValue = "%s %s".formatted(state.getState(), city);
        check("State and City", expectedValue);
        return this;
    }
}
