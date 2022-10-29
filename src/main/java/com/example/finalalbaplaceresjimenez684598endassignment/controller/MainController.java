package com.example.finalalbaplaceresjimenez684598endassignment.controller;

import com.example.finalalbaplaceresjimenez684598endassignment.logic.ItemService;
import com.example.finalalbaplaceresjimenez684598endassignment.model.Item;
import com.example.finalalbaplaceresjimenez684598endassignment.model.Member;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class MainController {

    private ItemService itemService;
    private Member member;
    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
    }

    public MainController() {
        itemService = new ItemService();
        // call the method to initialize the tables (add the data to the table)
    }


    //region Lending/receiving tab
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


    // Display member's name
    public void displayMemberName(Member member){
        nameOfUserLabel.setText("Welcome " + member.getFullName());
    }

    @FXML
    private void onLendItemButtonClick() throws IOException{
        if ((itemCodeLendingText.getText().isEmpty())||(memberIdentifierText.getText().isEmpty())){
            lendingMessageLabel.setText("Please fill in all the text fields");
        }
        else{
            // Get the item based on its entered item code
            Item item = itemService.getItemByItemCode(Integer.parseInt(itemCodeLendingText.getText()));
            // Get the entered member identifier
            int memberIdentifier = Integer.parseInt(memberIdentifierText.getText());

            if(Objects.nonNull(item) && item.isAvailable()){  // Check if item exists and if its available
                // Check if the member identifier belongs to the logged in member
                if (Objects.equals(memberIdentifier, member.getMemberIdentifier())){
                    item.setAvailable(false);   // Change status of the item
                    item.setLendingDate(LocalDate.now());   // Recording the lending date of the item
                    lendingMessageLabel.setText("The item status has changed"); // Informing of the change in the item's status
                }
                else{
                    lendingMessageLabel.setText("Member identifier is not correct");    // Show that the member doesn't exist
                }
            }
            else{
                lendingMessageLabel.setText("Item doesn't exist or its not available");  // Show that the item doesn't exist
            }
        }
    }

    @FXML
    private void onReceiveItemButtonClick() throws IOException{
        if (itemCodeReceivingText.getText().isEmpty()){
            receivingMessageLabel.setText("Please fill in the text field");
        }
        else{
            // Get the item based on its entered item code
            Item item = itemService.getItemByItemCode(Integer.parseInt(itemCodeReceivingText.getText()));

            if(Objects.nonNull(item) && !item.isAvailable()){  // Check if item exists and has been lent
                if (itemService.daysLate(item) > 0){ // If the item is late, show the late days
                    receivingMessageLabel.setText("The item is " + itemService.daysLate(item) + " days late");
                }
                item.setLendingDate(null);  // Clearing the lending date
                item.setAvailable(true);    // Changing status to available
                receivingMessageLabel.setText("Item received, its status has changed to available");
            }
            else {
                receivingMessageLabel.setText("Item doesn't exist or has never been lent"); // Show that the item doesn't exist
            }
        }
    }
    //endregion

    //region Collection tab

    @FXML
    private TableView<Item> collectionTable;
    @FXML
    private TableColumn<Item, Integer> itemCodeColumn;
    @FXML
    private TableColumn<Item, String> availableColumn;
    @FXML
    private TableColumn<Item, String> titleColumn;
    @FXML
    private TableColumn<Item, String> authorColumn;

    public void initializeCollectionTable(){
        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("hola"));
    }

    //endregion

    //region Members tab
    //endregion
}
