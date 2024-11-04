package frontend;

import backend.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CancelRegistration {
    public static void cancelRegistrationWindow() {
        Stage window = new Stage();
        window.setTitle("Cancel Registration");


        Label memberIdLabel = new Label("Member ID");
        TextField memberIdTxt = new TextField();
        Label classIdLabel = new Label("Class ID");
        TextField classIdTxt = new TextField();

        GridPane grid = new GridPane();
        grid.add(memberIdLabel, 0, 0);
        grid.add(memberIdTxt, 1, 0);
        grid.add(classIdLabel, 0, 1);
        grid.add(classIdTxt, 1, 1);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        Button cancelRegistrationButton = new Button("Cancel Registration");
        cancelRegistrationButton.setOnAction(e -> {
            if (Main.cancelRegistrationFromFrontend(memberIdTxt.getText(), classIdTxt.getText())) {
                AlertBox.display("Cancelled Successfully", "The Member with ID = " + memberIdTxt.getText() + " has been unregistered from Class" + classIdTxt.getText());
                window.close();
            }else
                AlertBox.display("Cancellation Failed", "Cannot Cancel Registration! Days limit reached.");
        });

        VBox cancelRegistrationLayout = new VBox(25, grid, cancelRegistrationButton);
        cancelRegistrationLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(cancelRegistrationLayout, 400, 300);
        window.setScene(scene);

        window.show();
    }
}
