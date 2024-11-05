package frontend;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.stage.Stage;

import java.util.Objects;

public class StartWindow extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage window) {

        Label gymTitle = new Label("Gym Abou Hadeed");
        gymTitle.getStyleClass().add("gym-title");

        Image logo = new Image(new File("gym.png").toURI().toString());
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(75);
        logoView.setPreserveRatio(true);

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
        startLayout.getChildren().addAll(logoView,gymTitle, adminRoleButton, trainerRoleButton);
        startLayout.setAlignment(Pos.CENTER);

        Scene startScene = new Scene(startLayout, 400, 500);
        startScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        window.setScene(startScene);
        window.setTitle("Gym System");

//        Media sound = new Media(new File("Infraction_-_Gym_Crossfit.mp3").toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();

        window.show();

    }
}
