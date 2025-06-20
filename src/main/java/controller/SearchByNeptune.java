package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Student;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchByNeptune implements Initializable {


    @FXML
    private TableView<Student> tbData;

    @FXML
    public TableColumn<Student, Integer> id;

    @FXML
    public TableColumn<Student, String> first_name;

    @FXML
    public TableColumn<Student, String> last_name;

    @FXML
    public TableColumn<Student, String> neptune_code;

    @FXML
    public TableColumn<Student, String> major;

    @FXML
    public TableColumn<Student, String> education_type;

    @FXML
    private TextField search;

    StudentController studentController = new StudentController();
    private ObservableList<Student> studentModels = FXCollections.observableArrayList(studentController.getAllStudents());

    @FXML
    private void backToMain(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/ui/ui.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        first_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        neptune_code.setCellValueFactory(new PropertyValueFactory<>("neptune_code"));
        major.setCellValueFactory(new PropertyValueFactory<>("major"));
        education_type.setCellValueFactory(new PropertyValueFactory<>("education_type"));
        tbData.setItems(studentModels);
    }

    public void searchStudents(){
        studentModels = FXCollections.observableArrayList(studentController.getStudentByNeptune(search.getText()));
        System.out.println(search.getText());
        System.out.println(studentController.getStudentByNeptune(search.getText()));
        tbData.setItems(studentModels);
    }


}
