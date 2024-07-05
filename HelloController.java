package com.example.hrmanagementavneet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    public TextField Username;
    public PasswordField Password;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {



        try {

            Parent secondScene = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("Dashboard Scene");
            secondStage.setScene(new Scene(secondScene));



            secondStage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    }
