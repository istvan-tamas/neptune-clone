import controller.StudentController;


public class Main {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        //studentController.createStudent(new model.Student(2, "Jane", "Doe", "NEP234", "Computer Science", "Graduate"));
        System.out.println(studentController.getAllStudents().get(1).toString());
    }
}
