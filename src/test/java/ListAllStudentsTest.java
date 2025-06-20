import controller.StudentController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListAllStudentsTest {

    private StudentController studentController = new StudentController();
    String nameToTest = "Jack";

    @BeforeEach
    void setUp() {
        studentController = new StudentController();
    }

    @Test
    void testStudentName() {
        Assertions.assertEquals(nameToTest, studentController.getAllStudents().get(1).getFirst_name());
    }

}
