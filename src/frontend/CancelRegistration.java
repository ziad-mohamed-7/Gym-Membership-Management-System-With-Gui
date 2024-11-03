package frontend;

import javafx.geometry.Pos;
import javafx.scene.Scene;
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

        Button cancelRegistrationButton = new Button("Cancel Registration");
        cancelRegistrationButton.setOnAction(e -> {
            window.close();
        });

        Label memberIdLabel = new Label("Member ID");
        TextField memberIdTxt = new TextField();
        Label classIdLabel = new Label("Class ID");
        TextField classIdTxt = new TextField();

        GridPane grid = new GridPane();
        grid.add(memberIdLabel, 0, 0);
        grid.add(memberIdTxt, 1, 0);
        grid.add(classIdLabel, 0, 1);
        grid.add(classIdTxt, 1, 1);

        VBox cancelRegistrationLayout = new VBox(grid, cancelRegistrationButton);
        cancelRegistrationLayout.setSpacing(10);
        cancelRegistrationLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(cancelRegistrationLayout, 400, 300);
        window.setScene(scene);

        window.show();
    }
}
