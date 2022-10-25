package com.example.finalalbaplaceresjimenez684598endassignment.ui;

import com.example.finalalbaplaceresjimenez684598endassignment.model.Member;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label nameOfUserLabel;

    public MainController() {
        //To fill in later
    }

    // Display member's name
    public void displayMemberName(Member member){
        nameOfUserLabel.setText("Welcome " + member.getFullName());
    }
}
