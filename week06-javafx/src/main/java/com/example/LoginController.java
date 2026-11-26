package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML
    private void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Error: Fields cannot be empty.");
            return;
        }

        System.out.println("Attempting login for: " + username);
        if (username.equals("admin") && password.equals("password123")) {
            System.out.println("Login Successful!");
            usernameField.clear();
            passwordField.clear();
        } else {
            System.out.println("Login Failed!");
        }
    }
}
