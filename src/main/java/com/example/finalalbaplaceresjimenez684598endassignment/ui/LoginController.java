package com.example.finalalbaplaceresjimenez684598endassignment.ui;

import com.example.finalalbaplaceresjimenez684598endassignment.LibraryApplication;
import com.example.finalalbaplaceresjimenez684598endassignment.logic.LoginService;
import com.example.finalalbaplaceresjimenez684598endassignment.logic.MemberService;
import com.example.finalalbaplaceresjimenez684598endassignment.model.Member;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    //region Variables
    private LoginService loginService;
    private MemberService memberService;
    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Label message;
    @FXML
    private Button loginButton;
    //endregion

    // Constructor
    public LoginController() {
        loginService = new LoginService();
        memberService = new MemberService();
    }

    @FXML
    private void onLoginButtonClick() throws IOException {
        // If some fields are empty ask the user to fill them in
        if ((usernameText.getText().isEmpty()) || (passwordText.getText().isEmpty())){
            message.setText("Please fill in all the text fields");
        }
        else{   // Once they are filled in, check if login is successful

            // If the login is successful, open the main window
            if(loginService.loginSuccessful(usernameText.getText(), passwordText.getText())){
                Member member = memberService.getMemberByUsername(usernameText.getText());  // Getting the logged in member
                Stage loginStage = (Stage)loginButton.getScene().getWindow();
                loginStage.close();
                openMainWindow(new Stage(), member);
            }

            else{   // If the login fails, let the user know with the user and empty the fields
                message.setText("Invalid username/password combination");
                usernameText.setText("");
                passwordText.setText("");
            }
        }
    }

    // Open the main library window with the data of the logged in member
    public void openMainWindow(Stage mainStage, Member member) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryApplication.class.getResource("main-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        mainStage.setTitle("Library system");
        mainStage.setScene(scene);
        mainStage.show();
        MainController mainController = fxmlLoader.getController();
        mainController.displayMemberName(member);
    }
}