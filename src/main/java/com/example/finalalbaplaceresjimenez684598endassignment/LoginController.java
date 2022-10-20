package com.example.finalalbaplaceresjimenez684598endassignment;

import com.example.finalalbaplaceresjimenez684598endassignment.dal.Database;
import com.example.finalalbaplaceresjimenez684598endassignment.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.Objects;

public class LoginController {
    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Label message;

    @FXML
    protected boolean onLoginButtonClick() {
        User user = new User("user", usernameText.getText(), passwordText.getText());
        for (User u: Database.getUsers()) {
            if ((Objects.equals(u.getUsername(), user.getUsername())) && (Objects.equals(u.getPassword(), user.getPassword()))){
                return true;
            }
        }
        message.setText("Invalid username/password combination");
        return false;
    }
}