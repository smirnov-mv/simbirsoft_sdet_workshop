package local.pages.practice_form;

import java.util.List;
import java.util.Random;

public class SubjectsList {
    public static List<String> subjects = List.of(
            "Hindi", "English", "Maths", "Physics", "Chemistry",
            "Biology", "Computer Science", "Commerce", "Accounting",
            "Economics", "Arts", "Social Studies", "History", "Civics"
    );

    public static String randomSubject = subjects.get(new Random().nextInt(subjects.size()));
}
