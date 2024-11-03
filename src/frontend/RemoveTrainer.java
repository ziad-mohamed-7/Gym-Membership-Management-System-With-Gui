package frontend;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RemoveTrainer {
    public static void display(){
        Stage removeTrainerWindow = new Stage();
        removeTrainerWindow.setTitle("Remove Trainer");

        Label trainerIdLabel = new Label("Trainer ID");
        TextField trainerIdTextField = new TextField();
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e -> {
//            Main.
            removeTrainerWindow.close();
        });

        HBox removeTrainerLayout = new HBox(trainerIdLabel, trainerIdTextField, removeButton);
        removeTrainerLayout.setAlignment(Pos.CENTER);
        removeTrainerLayout.setSpacing(15);

        Scene removeTrainerScene = new Scene(removeTrainerLayout, 500, 200);
        removeTrainerWindow.setScene(removeTrainerScene);
        removeTrainerWindow.show();
    }
}
