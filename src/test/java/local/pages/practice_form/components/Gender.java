package local.pages.practice_form.components;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    public final String value;

    Gender(String value) {
        this.value = value;
    }
}