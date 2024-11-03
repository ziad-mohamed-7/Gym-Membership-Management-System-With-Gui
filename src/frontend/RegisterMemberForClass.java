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

        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> {
            if (!memberIdTxt.getText().isEmpty() && !classIdTxt.getText().isEmpty()) {
//                Main.registerFromFrontend(memberIdTxt.getText(), classIdTxt.getText(), registrationDate.getValue())
//                    AlertBox.display("Registered Successfully", "The member with ID = " + memberIdTxt.getText() + "has successfully registered to class " + classIdTxt.getText());
                    window.close();

//                    AlertBox.display("Already Exist", "The Member with ID = " + idTextField.getText() + " already exists.");
            }
        });

        VBox registerLayout = new VBox(grid, registerButton);
        registerLayout.setSpacing(10);
        registerLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(registerLayout, 400, 300);
        window.setScene(scene);

        window.show();
    }
}
