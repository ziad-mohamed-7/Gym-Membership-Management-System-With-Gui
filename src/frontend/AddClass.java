package frontend;

import backend.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddClass {
    public static void addClassWindow() {
        Stage addClassWindow = new Stage();
        addClassWindow.setTitle("Add Class");

        Label classIdLabel = new Label("Class ID");
        TextField classIdTxt = new TextField();

        Label classNameLabel = new Label("Class Name");
        TextField classNameTxt = new TextField();

        Label trainerIdLabel = new Label("Trainer ID");
        TextField trainerIdTxt = new TextField();

        Label durationLabel = new Label("Duration");
        TextField durationTxt = new TextField();

        Label maxParticipantsLabel = new Label("Max Participants");
        TextField maxParticipantsTxt = new TextField();


        GridPane grid = new GridPane();
        grid.add(classIdLabel, 0, 0);
        grid.add(classIdTxt, 1, 0);
        grid.add(classNameLabel, 0, 1);
        grid.add(classNameTxt, 1, 1);
        grid.add(trainerIdLabel, 0, 2);
        grid.add(trainerIdTxt, 1, 2);
        grid.add(durationLabel, 0, 3);
        grid.add(durationTxt, 1, 3);
        grid.add(maxParticipantsLabel, 0, 4);
        grid.add(maxParticipantsTxt, 1, 4);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        Button add = new Button("Add");
        add.setOnAction(e -> {
            if (!classIdTxt.getText().isEmpty() && !classNameTxt.getText().isEmpty() && !trainerIdTxt.getText().isEmpty() && !durationTxt.getText().isEmpty()) {
                if (Main.addClassFromFrontend(classIdTxt.getText(), classNameTxt.getText(), trainerIdTxt.getText(), Integer.parseInt(durationTxt.getText()), Integer.parseInt(maxParticipantsTxt.getText()))) {
                    AlertBox.display("Class Added", "Class with ID = " + classIdTxt.getText() + " added successfully.");
                    addClassWindow.close();
                }else
                    AlertBox.display("Already Exists", "Class with ID = " + classIdTxt.getText() + " already exists.");
            }else
                AlertBox.display("Empty Fields", "Some Fields are Empty!!");
        });

        VBox addClassLayout = new VBox(grid, add);
        addClassLayout.setAlignment(Pos.CENTER);
        addClassLayout.setSpacing(15);

        Scene addClassScene = new Scene(addClassLayout, 400, 300);
        addClassScene.getStylesheets().add(AddClass.class.getResource("styles.css").toExternalForm());

        addClassWindow.setScene(addClassScene);

        addClassWindow.show();
    }
}
