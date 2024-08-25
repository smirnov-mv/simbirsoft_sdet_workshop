package local.pages.practice_form.components;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Form {

    @Step("[Step] Заполняем поле First Name значением [{0}]")
    public Form enterFirstName(String firstName) {
        $(byId("firstName")).sendKeys(firstName);
        return this;
    }

    @Step("[Step] Заполняем поле Last Name значением [{0}]")
    public Form enterLastName(String lastName) {
        $(byId("lastName")).sendKeys(lastName);
        return this;
    }

    @Step("[Step] Заполняем поле Email значением [{0}]")
    public Form enterEmail(String email) {
        $(byId("userEmail")).sendKeys(email);
        return this;
    }

    @Step("[Step] Выбираем Gender [{gender.value}]")
    public Form selectGender(Gender gender) {
        $(byId("genterWrapper")).$(byText(gender.value)).click();
        return this;
    }

    @Step("[Step] Заполняем поле Mobile [{0}]")
    public Form enterMobileNumber(String mobileNumber) {
        $(byId("userNumber")).sendKeys(mobileNumber);
        return this;
    }

    @Step("[Step] Заполняем поле Date of birth с помощью всплывающего календаря [{0}]")
    public Form enterDateOfBirth(LocalDate dateOfBirth) {
        $(byId("dateOfBirthInput")).click();
        SelenideElement dateContainer = $(".react-datepicker__month-container");
        DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("MMMM d", Locale.ENGLISH);

        dateContainer.$(".react-datepicker__year-select").click();
        dateContainer.$(".react-datepicker__year-select option[value='%s']".formatted(dateOfBirth.getYear())).click();
        dateContainer.$(".react-datepicker__month-select").click();
        dateContainer.$(".react-datepicker__month-select option[value='%s']".formatted((dateOfBirth.getMonth().getValue() - 1))).click();

        dateContainer.$(Selectors.byAttribute("aria-label*", dateOfBirth.format(formatterDay))).click();

        return this;
    }

    @Step("[Step] Заполняем поле Subjects [{0}]")
    public Form enterAndSelectSubject(String subject) {
        $x("//*[contains(@class, 'subjects-auto-complete__value-container')]").click();
        Selenide.actions().sendKeys(subject).perform();
        $(".subjects-auto-complete__menu").$(byText(subject)).click();
        return this;
    }

    @Step("[Step] Загружаем изображение")
    public Form uploadPicture() {
        $(byId("uploadPicture")).uploadFromClasspath("images/Toolsqa.jpg");
        return this;
    }

    @Step("[Step] Заполняем поле Current Address [{0}]")
    public Form enterCurrentAddress(String currentAddress) {
        $(byId("currentAddress")).sendKeys(currentAddress);
        return this;
    }

    @Step("[Step] Выбираем значение в Select State с помощью выпадающего списка [{0}]")
    public Form selectState(StateWithCity state) {
        $(byId("state")).click();
        $$("[id*='react-select-3-option']").findBy(exactTextCaseSensitive(state.getState())).click();
        return this;
    }

    @Step("[Step] Выбираем значение в Select City с помощью выпадающего списка [{0}]")
    public Form selectCity(String city) {
        $(byId("city")).click();
        $$("[id*='react-select-4-option']").findBy(exactTextCaseSensitive(city)).click();
        return this;
    }

    @Step("[Step] Нажимаем кнопку Submit")
    public void pressSubmit() {
        $(byId("submit")).click();
    }
}
