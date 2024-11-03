package frontend;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.text.View;

public class AdminRoleMenu {
    public static void display() {
        Button addTrainerButton = new Button("Add Trainer");
        addTrainerButton.setOnAction(e -> AddPerson.addPersonWindow("Trainer"));

        Button removeTrainerButton = new Button("Remove Trainer");
        removeTrainerButton.setOnAction(e -> RemoveTrainer.display());

        Button viewTrainersButton = new Button("View Trainers");
        viewTrainersButton.setOnAction(e -> ViewTrainers.display());

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> Logout.display());

        VBox adminRoleMenuLayout = new VBox(30, addTrainerButton, removeTrainerButton, viewTrainersButton, logoutButton);
        adminRoleMenuLayout.setAlignment(Pos.CENTER);
        adminRoleMenuLayout.setSpacing(50);

        Scene adminRoleMenuScene = new Scene(adminRoleMenuLayout, 400, 400);

        Stage AdminRoleMenuWindow = new Stage();
        AdminRoleMenuWindow.setTitle("Admin Role Menu");
        AdminRoleMenuWindow.setScene(adminRoleMenuScene);
        AdminRoleMenuWindow.show();
    }
}
