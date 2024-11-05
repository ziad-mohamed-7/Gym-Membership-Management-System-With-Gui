package frontend;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class AlertBox {

    public static void display(String title, String message, boolean error) {


        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Image errorLogo = new Image(new File("src/resources/error.png").toURI().toString());
        ImageView errorLogoView = new ImageView(errorLogo);
        errorLogoView.setFitWidth(50);
        errorLogoView.setPreserveRatio(true);

        Image passLogo = new Image(new File("src/resources/passed.png").toURI().toString());
        ImageView passLogoView = new ImageView(passLogo);
        passLogoView.setFitWidth(50);
        passLogoView.setPreserveRatio(true);

        Label alertMessage = new Label(message);

        HBox messageLayout = new HBox(20);



        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox alertLayout = new VBox(20);
        alertLayout.getChildren().addAll(messageLayout, closeButton);
        alertLayout.setAlignment(Pos.CENTER);

        Scene alertScene = new Scene(alertLayout, 500, 150);
        alertScene.getStylesheets().add(AlertBox.class.getResource("styles.css").toExternalForm());

        if (error) {
            messageLayout.getChildren().add(errorLogoView);
        } else {
            messageLayout.getChildren().add(passLogoView);
        }
        messageLayout.getChildren().add(alertMessage);
        messageLayout.setAlignment(Pos.CENTER);

        window.setScene(alertScene);
        window.showAndWait();

    }
}
