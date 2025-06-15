package controller.interfaces;

import model.Student;

import java.util.ArrayList;

public interface StudentControllerInterface {

    public void createStudent(Student student);

    public ArrayList<Student> getAllStudents();

    public void getStudentById();

    public void updateStudent();

    public void deleteStudentById();

}
