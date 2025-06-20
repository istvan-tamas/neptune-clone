package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Student;

import java.io.IOException;

public class UpdateStudentController {

    @FXML
    private TextField id;

    @FXML
    private TextField first_name;

    @FXML
    private TextField last_name;

    @FXML
    private TextField neptune_code;

    @FXML
    private TextField major;

    @FXML
    private TextField education_type;

    @FXML
    private void backToMain(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/ui/ui.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void updateStudent(ActionEvent event) {
        StudentController studentController = new StudentController();
        studentController.updateStudent(Integer.parseInt(id.getText()),first_name.getText(),last_name.getText(),neptune_code.getText(),major.getText(),education_type.getText());
    }



}
