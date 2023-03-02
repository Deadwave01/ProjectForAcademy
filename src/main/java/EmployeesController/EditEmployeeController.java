package EmployeesController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.vladwave.projectfortopacademy.Employee;
import com.vladwave.projectfortopacademy.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class EditEmployeeController {
    static Employee editEmployee;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea getBossNSP;

    @FXML
    private TextArea getDepartamentName;

    @FXML
    private TextArea getDateEmployment;

    @FXML
    private TextArea getSalary;


    @FXML
    private Button getEditData;

    @FXML
    private TextArea getNSP;

    @FXML
    private TextArea getRang;



    @FXML
    void initialize() {
        getNSP.setText(editEmployee.getSurname() + " " + editEmployee.getName() + " " + editEmployee.getPatronymic());
        getRang.setText(editEmployee.getRang());
        getDepartamentName.setText(editEmployee.getDepartmentname());
        getBossNSP.setText(editEmployee.getBosssurname() + " " + editEmployee.getBossname() + " " + editEmployee.getBosspatronymic());
        getSalary.setText(editEmployee.getSalary());
        getDateEmployment.setText(editEmployee.getDataofemployment());
        getEditData.setOnAction(actionEvent -> {
            String[] NSP = getNSP.getText().toString().split(" ");
            String DepName = getDepartamentName.getText().toString();
            String Rang = getRang.getText().toString();
            String[] BNSP = getBossNSP.getText().toString().split(" ");
            String salary = getSalary.getText().toString();
            String DataEmployment = getDateEmployment.getText().toString();
            editEmployee.editEmployee(NSP[1], NSP[0], NSP[2], Rang, DepName, BNSP[1], BNSP[0], BNSP[2],salary,DataEmployment);
            Stage stage = HelloApplication.getKeystage();
            stage.hide();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("employees.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 790, 400);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Employees");
            stage.setScene(scene);
            stage.show();
        });
    }
}

