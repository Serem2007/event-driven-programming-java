package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UnidirectionalDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField nameField = new TextField();
        nameField.setPromptText("Type your name here...");
        Label greetingLabel = new Label("Hello, Guest");

        VBox root = new VBox(20, nameField, greetingLabel);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        greetingLabel.textProperty().bind(
            nameField.textProperty().concat(", welcome!")
        );

        primaryStage.setTitle("Unidirectional Binding");
        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
