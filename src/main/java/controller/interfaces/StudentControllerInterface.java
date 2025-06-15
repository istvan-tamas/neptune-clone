package controller.interfaces;

import model.Student;

import java.util.ArrayList;

public interface StudentControllerInterface {

    public void createStudent(Student student);

    public ArrayList<Student> getAllStudents();

    public Student getStudentById(int id);

    public int updateStudent(int id, String first_name, String last_name, String neptune_code, String major, String education_type);

    public void deleteStudentById(int id);

}
