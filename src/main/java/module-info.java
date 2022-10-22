module com.example.finalalbaplaceresjimenez684598endassignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalalbaplaceresjimenez684598endassignment to javafx.fxml;
    exports com.example.finalalbaplaceresjimenez684598endassignment;
    exports com.example.finalalbaplaceresjimenez684598endassignment.ui;
    opens com.example.finalalbaplaceresjimenez684598endassignment.ui to javafx.fxml;
}