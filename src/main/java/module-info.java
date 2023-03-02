module com.vladwave.projectfortopacademy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vladwave.projectfortopacademy to javafx.fxml;
    exports com.vladwave.projectfortopacademy;
    exports EmployeesController;
    opens EmployeesController to javafx.fxml;
}