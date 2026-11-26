package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EventPropagationDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label logLabel = new Label("Click the button...");
        Button btn = new Button("Click Me!");
        VBox root = new VBox(20, logLabel, btn);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Capturing phase: root sees the event before the button.
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println("1. [FILTER] Root intercepted the click!");
            // Uncomment to stop the event reaching the button:
            // e.consume();
        });

        // Bubbling phase: event travels back up from the target.
        root.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->
            System.out.println("3. [HANDLER] Root saw the click bubbling up!"));

        btn.setOnMouseClicked(e -> {
            System.out.println("2. [HANDLER] Button was clicked!");
            logLabel.setText("Button was clicked!");
        });

        primaryStage.setTitle("Event Propagation");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
