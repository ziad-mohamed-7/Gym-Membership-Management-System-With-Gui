package frontend;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Logout {
    static boolean answer;

    public static boolean display(){
        Stage window = new Stage();
        window.setTitle("Logout");
        window.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label("Are you sure you want to logout?");
        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        Button noButton = new Button("No");
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });
        HBox logoutButtonsLayout = new HBox(10);
        logoutButtonsLayout.getChildren().addAll(yesButton, noButton);
        logoutButtonsLayout.setAlignment(Pos.CENTER);
        VBox logoutFinalLayout = new VBox(10);
        logoutFinalLayout.getChildren().addAll(label, logoutButtonsLayout);
        logoutFinalLayout.setAlignment(Pos.CENTER);

        Scene logoutScene = new Scene(logoutFinalLayout, 400, 100);
        window.setScene(logoutScene);
        window.showAndWait();
        return answer;
    }
}
