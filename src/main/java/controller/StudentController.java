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

    public ArrayList<Student> getStudentByNeptune(String neptune)
    {
        var students = new ArrayList<Student>();
        var sql = "SELECT id, first_name, last_name, neptune, major, education_type FROM student WHERE neptune LIKE ?";
        try (var conn =  DB.connect();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, neptune);
            var rs = stmt.executeQuery();
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
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public int updateStudent(int id, String first_name, String last_name, String neptune, String major, String education_type)
    {
        var sql  = "UPDATE student "
                + "SET first_name = ?, last_name = ?, neptune = ?, major = ?, education_type= ? "
                + "WHERE id = ?";
        int affectedRows = 0;
        try (var conn  = DB.connect();
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, neptune);
            pstmt.setString(4, major);
            pstmt.setString(5, education_type);
            pstmt.setInt(6, id);
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public void deleteStudentById(int id)
    {
        var sql  = "DELETE FROM student WHERE id=?";
        try (var conn  = DB.connect();
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.printf("Student with id %d deleted\n", id);
        } catch (SQLException e) {
            System.out.println("Student not deleted");
            e.printStackTrace();
        }
    }

}
