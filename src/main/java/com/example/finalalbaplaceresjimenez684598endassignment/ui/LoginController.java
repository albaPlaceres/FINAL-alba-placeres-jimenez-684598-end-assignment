package com.example.finalalbaplaceresjimenez684598endassignment.ui;

import com.example.finalalbaplaceresjimenez684598endassignment.logic.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    private LoginService loginService;
    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Label message;
    @FXML
    private Button loginButton;

    // Constructor
    public LoginController() {
        loginService = new LoginService();
    }

    @FXML
    private void onLoginButtonClick() {
        // If some fields are empty ask the user to fill them in
        if ((usernameText.getText().isEmpty()) || (passwordText.getText().isEmpty())){
            message.setText("Please fill in all the text fields");
        }
        else{   // Once they are filled in, check if login is successful
            if(loginService.loginSuccessful(usernameText.getText(), passwordText.getText())){
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();
            }
            else{   // If the login fails, communicate the information with the user and empty the fields
                message.setText("Invalid username/password combination");
                usernameText.setText("");
                passwordText.setText("");
            }
        }
    }
}