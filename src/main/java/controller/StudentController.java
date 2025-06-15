package controller;

import controller.interfaces.StudentControllerInterface;
import database.DB;
import model.Student;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentController implements StudentControllerInterface {

    public void createStudent(Student student){
        var sql = "INSERT INTO student(first_name, last_name, neptune, major, education_type) "
                + "VALUES(?,?,?,?,?)";
        try (var conn =  DB.connect()) {
            assert conn != null;
            try (var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstmt.setString(1, student.getFirst_name());
                pstmt.setString(2, student.getLast_name());
                pstmt.setString(3, student.getNeptune_code());
                pstmt.setString(4, student.getMajor());
                pstmt.setString(5, student.getEducation_type());

                int insertedRow = pstmt.executeUpdate();
                if (insertedRow > 0) {
                    var rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                        System.out.println("Student created with id: " + rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Student not created");
            e.printStackTrace();
        }
    }


    public ArrayList<Student> getAllStudents()
    {
        var students = new ArrayList<Student>();
        var sql = "SELECT id, first_name, last_name, neptune, major, education_type FROM student";
        try (var conn =  DB.connect();
             var stmt = conn.createStatement()) {
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                var student = new Student(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("neptune"),
                                rs.getString("major"),
                                rs.getString("education_type"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void getStudentById()
    {

    }

    public void updateStudent()
    {

    }

    public void deleteStudentById()
    {

    }

}
