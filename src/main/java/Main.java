import controller.StudentController;


public class Main {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        //studentController.createStudent(new model.Student(2, "Jane", "Doe", "NEP234", "Computer Science", "Graduate"));
        //studentController.deleteStudentById(2);
        //System.out.println(studentController.updateStudent(1, "John", "Doe", "NEP123", "Computer engineering", "Graduate"));
        System.out.println(studentController.getStudentById(1));
    }
}
