package local.tests;

import com.github.javafaker.Faker;
import local.jupiter.WebTest;
import local.pages.practice_form.PracticeFormPage;
import local.pages.practice_form.components.SubjectsList;
import local.pages.practice_form.components.Gender;
import local.pages.practice_form.components.StateWithCity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Random;

import static io.qameta.allure.Allure.step;


@WebTest
public class FillRegistrationFormTest {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    Random random = new Random();
    Faker faker = new Faker();

    int year = 1980 + random.nextInt(40);
    int month = 1 + random.nextInt(12);
    int day = 1 + random.nextInt(LocalDate.of(year, month, 1).lengthOfMonth());

    @Test
    @DisplayName("Заполнение формы регистрации")
    void test() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String emailAddress = faker.internet().emailAddress();
        Gender randomGender = faker.options().option(Gender.class);
        String mobileNumber = faker.numerify("##########");
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        String subject = SubjectsList.randomSubject;
        String currentAddress = faker.address().fullAddress();
        StateWithCity state = faker.options().option(StateWithCity.class);
        String city = state.getRandomCity();

        step("Открываем страницу", () -> {
            practiceFormPage
                    .openPage()
                    .shouldBeLoaded();
        });

        step("Заполняем форму и нажимаем отправку", () -> {
            practiceFormPage
                    .form()
                    .enterFirstName(firstName)
                    .enterLastName(lastName)
                    .enterEmail(emailAddress)
                    .selectGender(randomGender)
                    .enterMobileNumber(mobileNumber)
                    .enterDateOfBirth(dateOfBirth)
                    .enterAndSelectSubject(subject)
                    .uploadPicture()
                    .enterCurrentAddress(currentAddress)
                    .selectState(state)
                    .selectCity(city)
                    .pressSubmit();
        });
        step("Проверяем данные в модалке", () -> {
            practiceFormPage
                    .modalSubmittedTable()
                    .shouldBeVisible()
                    .shouldHaveName(firstName, lastName)
                    .shouldHaveEmail(emailAddress)
                    .shouldHaveGender(randomGender)
                    .shouldHaveMobile(mobileNumber)
                    .shouldHaveDateOfBirth(dateOfBirth)
                    .shouldHaveSubjects(subject)
                    .checkPicture()
                    .shouldHaveAddress(currentAddress)
                    .shouldHaveStateAndCity(state, city);
        });
    }
}
