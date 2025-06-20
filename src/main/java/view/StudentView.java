package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentView {

    @FXML
    private void showAllStudents(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/ui/all-students.fxml"));
        stage.setScene(new Scene(root));
        stage.show();

    }


    @FXML
    private void backToMain(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/ui/ui.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void addNewStudent(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/ui/new-student.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void updateStudent(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/ui/update-student.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void deleteStudentById(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/ui/delete-student.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void searchByNeptune(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/ui/search-by-neptune.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

}
