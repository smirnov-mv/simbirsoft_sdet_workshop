package local.pages.practice_form;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;
import local.pages.practice_form.components.Form;
import local.pages.practice_form.components.ModalSubmittedTable;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    @Step("[Step] Открываем страницу [automation-practice-form]")
    public PracticeFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    @Step("[Check] Страница должна загрузиться")
    public PracticeFormPage shouldBeLoaded() {
        $(Selectors.byText("Practice Form")).shouldBe(Condition.visible);
        return this;
    }

    public Form form() {
        return new Form();
    }

    public ModalSubmittedTable modalSubmittedTable() {
        return new ModalSubmittedTable();
    }
}
