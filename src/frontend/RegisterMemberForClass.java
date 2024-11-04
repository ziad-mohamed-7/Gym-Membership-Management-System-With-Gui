package frontend;

import backend.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;


public class RegisterMemberForClass {
    public static void registerWindow() {
        Stage window = new Stage();
        window.setTitle("Register Member");


        Label memberIdLabel = new Label("Member ID");
        TextField memberIdTxt = new TextField();
        Label classIdLabel = new Label("Class ID");
        TextField classIdTxt = new TextField();
        Label registrationLabel = new Label("Registration Date");
        DatePicker registrationDate = new DatePicker(LocalDate.now());

        GridPane grid = new GridPane();
        grid.add(memberIdLabel, 0, 0);
        grid.add(memberIdTxt, 1, 0);
        grid.add(classIdLabel, 0, 1);
        grid.add(classIdTxt, 1, 1);
        grid.add(registrationLabel, 0, 2);
        grid.add(registrationDate, 1, 2);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> {
            if (!memberIdTxt.getText().isEmpty() && !classIdTxt.getText().isEmpty()) {
                switch (Main.registerFromFrontend(memberIdTxt.getText(), classIdTxt.getText(), registrationDate.getValue())) {
                    case 0 ->
                            AlertBox.display("Does Not Exist", "The Class " + classIdTxt.getText() + " does not exist.");
                    case 1 ->
                            AlertBox.display("No Seats", "The Class " + classIdTxt.getText() + " has no available seats.");
                    case 2 ->
                            AlertBox.display("Already Exists", "The member with ID = " + memberIdTxt.getText() + "is already registered to class " + classIdTxt.getText());
                    case 3 -> {
                        AlertBox.display("Registered Successfully", "The member with ID = " + memberIdTxt.getText() + "has successfully registered to class " + classIdTxt.getText());
                        window.close();
                    }
                }
            }else
                AlertBox.display("Empty Fields", "Some Fields are Empty!!");
        });


        VBox registerLayout = new VBox(25, grid, registerButton);
        registerLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(registerLayout, 400, 300);
        window.setScene(scene);

        window.show();
    }
}
