import controller.StudentController;
import javafx.application.Application;


public class Main {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        Application.launch(SceneSwitch.class, args);
    }
}
