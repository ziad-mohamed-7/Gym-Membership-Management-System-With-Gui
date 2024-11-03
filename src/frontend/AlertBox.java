package frontend;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label alertMessage = new Label(message);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox alertLayout = new VBox(20);
        alertLayout.getChildren().addAll(alertMessage, closeButton);
        alertLayout.setAlignment(Pos.CENTER);

        Scene alertScene = new Scene(alertLayout, 400, 100);
        window.setScene(alertScene);
        window.showAndWait();

    }
}
