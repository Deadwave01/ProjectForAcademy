package com.vladwave.projectfortopacademy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Stage keystage;

    public static Stage getKeystage() {
        return keystage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("employees.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 790,400);
        stage.setTitle("Employees");
        stage.setScene(scene);
        stage.show();
        keystage = stage;
    }

    public static void main(String[] args) {
        launch();
    }
}