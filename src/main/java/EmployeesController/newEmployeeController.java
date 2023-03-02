package EmployeesController;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.vladwave.projectfortopacademy.Employee;
import com.vladwave.projectfortopacademy.HelloApplication;
import com.vladwave.projectfortopacademy.WritetoFile;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class newEmployeeController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea getDateEmployment;

    @FXML
    private TextArea getSalary;

    @FXML
    private TextArea getBossNSP;

    @FXML
    private Button getContributeData;

    @FXML
    private TextArea getDepartamentName;

    @FXML
    private TextArea getNSP;

    @FXML
    private TextArea getRang;

    @FXML
    void initialize() {
        getContributeData.setOnAction(actionEvent -> {
            if(getNSP != null & getDepartamentName != null & getRang != null & getBossNSP != null){
                String[] NSP = getNSP.getText().toString().split(" ");
                String DepName = getDepartamentName.getText().toString();
                String Rang = getRang.getText().toString();
                String[] BNSP = getBossNSP.getText().toString().split(" ");
                String Salary = getSalary.getText().toString();
                String DataEmployment = getDateEmployment.getText().toString();
                Employee employee = new Employee(NSP[1],NSP[0],NSP[2],Rang,DepName,BNSP[1],BNSP[0],BNSP[2],Salary,DataEmployment);
                Employee.addEmployeeinList(employee);
                try {
                    WritetoFile.writeinfile(employee);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = HelloApplication.getKeystage();
                stage.hide();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("employees.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(), 790,400);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setTitle("Employees");
                stage.setScene(scene);
                stage.show();
            }
        });
    }

}
