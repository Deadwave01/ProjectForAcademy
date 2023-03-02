package EmployeesController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import com.vladwave.projectfortopacademy.Employee;
import com.vladwave.projectfortopacademy.HelloApplication;
import com.vladwave.projectfortopacademy.WritetoFile;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableView;


public class EmployeesController {

    static Stage activitestage;



    @FXML
    private TableView<Employee> getTableView;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label BossNameDetalis;

    @FXML
    private Label BossPatronymicDetalis;

    @FXML
    private Label BossSurnameDetalis;

    @FXML
    private Button DeleteEmployeesButton;

    @FXML
    private Label DepartmentNameDetalis;

    @FXML
    private Button EditEmployeeButton;

    @FXML
    private Label NameDetalis;

    @FXML
    private Button NewEmployeeButton;

    @FXML
    private Label PatronymicDetalis;

    @FXML
    private TableColumn<Employee,String> NameTable;

    @FXML
    private TableColumn<Employee,String> SurnameTable;

    @FXML
    private Label RangDetalis;

    @FXML
    private Label SurnameDetalis;

    @FXML
    private Label getSalaryDetalis;

    @FXML
    private Label getDataEmploymentDetalis;

    @FXML
    void initialize() throws IOException {
        WritetoFile.read();
        ///////Отображение по столбцам имена и фамилии из обсерверлиста
        NameTable.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        SurnameTable.setCellValueFactory(new PropertyValueFactory<Employee,String>("surname"));
        getTableView.setItems(Employee.getEmployeeList());

        TableView.TableViewSelectionModel<Employee> selectionModel = getTableView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Employee>(){
            @Override
            public void changed(ObservableValue<? extends Employee> observableValue, Employee employee, Employee t1) {
                if(t1 != null) {
                    NameDetalis.setText(t1.getName());
                    SurnameDetalis.setText(t1.getSurname());
                    PatronymicDetalis.setText(t1.getPatronymic());
                    RangDetalis.setText(t1.getRang());
                    DepartmentNameDetalis.setText(t1.getDepartmentname());
                    BossNameDetalis.setText(t1.getBossname());
                    BossSurnameDetalis.setText(t1.getBosssurname());
                    BossPatronymicDetalis.setText(t1.getBosspatronymic());
                    getSalaryDetalis.setText(t1.getSalary());
                    getDataEmploymentDetalis.setText(t1.getDataofemployment());
                } else {
                   settextfordetalis();
                }
            }
        });
        //////Новый сотрудник
        NewEmployeeButton.setOnAction(actionEvent -> {
            try {
                openwindownewemployee();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        /////Удаление сотрудника
        DeleteEmployeesButton.setOnAction(actionEvent -> {
            try {
                WritetoFile.deleteToFile(selectionModel.getSelectedItem());
                initialize();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ////Изменение сотрудника
        EditEmployeeButton.setOnAction(actionEvent -> {
            try {
                EditEmployeeController.editEmployee = selectionModel.getSelectedItem();
                openwindoweditemployee();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    //////Отображение лейблов
    private void settextfordetalis(){
        NameDetalis.setText("");
        SurnameDetalis.setText("");
        PatronymicDetalis.setText("");
        RangDetalis.setText("");
        DepartmentNameDetalis.setText("");
        BossNameDetalis.setText("");
        BossSurnameDetalis.setText("");
        BossPatronymicDetalis.setText("");
        getSalaryDetalis.setText("");
        getDataEmploymentDetalis.setText("");
    }

    /////Окно для новых сотрудников
    private void openwindownewemployee() throws IOException {
        Stage stage = HelloApplication.getKeystage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewEmployee.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 570,268);
        stage.setTitle("newEmployee");
        stage.setScene(scene);
        stage.show();
    }

    /////Окно для редактирования сотрудников
    private void openwindoweditemployee() throws IOException {
        Stage stage = HelloApplication.getKeystage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("editEmployee.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 570,268);
        stage.setTitle("EditEmployee");
        stage.setScene(scene);
        stage.show();
    }

}
