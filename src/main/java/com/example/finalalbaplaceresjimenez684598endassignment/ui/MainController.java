package com.example.finalalbaplaceresjimenez684598endassignment.ui;

import com.example.finalalbaplaceresjimenez684598endassignment.logic.ItemService;
import com.example.finalalbaplaceresjimenez684598endassignment.model.Item;
import com.example.finalalbaplaceresjimenez684598endassignment.model.Member;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Objects;

public class MainController {

    //region Variables
    private ItemService itemService;
    @FXML
    private Label nameOfUserLabel;
    @FXML
    private Label lendingMessageLabel;
    @FXML
    private Label receivingMessageLabel;
    @FXML
    private TextField itemCodeLendingText;
    @FXML
    private TextField memberIdentifierText;
    @FXML
    private TextField itemCodeReceivingText;
    //endregion

    public MainController() {
        itemService = new ItemService();
    }

    // Display member's name
    public void displayMemberName(Member member){
        nameOfUserLabel.setText("Welcome " + member.getFullName());
    }

    @FXML
    private void onLendItemButtonClick() throws IOException{

        // Comprobar si el itemCode y memberIdentifier son correctos !!!!!!!!!!!!!!!!!!!!!!!!

        int itemCode = Integer.parseInt(itemCodeLendingText.getText());     // Getting the item code
        Item item = itemService.getItemByItemCode(itemCode);    // Getting the item data based on its item code
        item.setAvailable(false);   // Change status of the item
        item.setLendingDate(LocalDate.ofEpochDay(Calendar.DATE));   // Recording the lending date of the item
        lendingMessageLabel.setText("The item status has changed");    // Informing of the change in the item's status
    }

    @FXML
    private void onReceiveItemButtonClick() throws IOException{

        // Comprobar si el itemCode es correcto !!!!!!!!!!!!!!!!!!!!!!!!

        int itemCode = Integer.parseInt(itemCodeLendingText.getText());     // Getting the item code
        Item item = itemService.getItemByItemCode(itemCode);    // Getting the item data based on its item code
        LocalDate threeWeeksPastLendingDate = item.getLendingDate().plusWeeks(3);   // 3 weeks after lending date
        if(item.getLendingDate().isAfter(threeWeeksPastLendingDate)){   // Check if it has passed more than 3 weeks
            long lateTime = threeWeeksPastLendingDate.until(item.getLendingDate(), ChronoUnit.DAYS);    // Days late
            receivingMessageLabel.setText("The item is " + lateTime + " days late");
        }

        item.setLendingDate(null);  // Clearing the lending date
        item.setAvailable(true);    // Changing status to available
    }
}
