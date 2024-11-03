package frontend;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartWindow extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage window) {
        Button adminRoleButton = new Button("Admin Role");
        adminRoleButton.setOnAction(e -> {
            AdminLogin.display();
            window.close();
        });

        Button trainerRoleButton = new Button("Trainer Role");
        trainerRoleButton.setOnAction(e -> {
            TrainerLogin.display();
            window.close();
        });

        VBox startLayout = new VBox(50);
        startLayout.getChildren().addAll(adminRoleButton, trainerRoleButton);
        startLayout.setAlignment(Pos.CENTER);

        Scene startScene = new Scene(startLayout, 300, 300);
        startScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        window.setScene(startScene);
        window.setTitle("Gym System");
        window.show();

    }
}
