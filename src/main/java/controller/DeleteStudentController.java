package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteStudentController {

    @FXML
    private TextField id;

    @FXML
    private void backToMain(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/ui/ui.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void deleteStudent(ActionEvent event) {
        StudentController studentController = new StudentController();
        studentController.deleteStudentById(Integer.parseInt(id.getText()));
    }
}
