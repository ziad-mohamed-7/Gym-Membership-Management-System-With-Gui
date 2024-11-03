package frontend;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrainerRoleMenu {
    public static void display() {
        Button addMemberButton = new Button("Add Member");
        addMemberButton.setOnAction(e -> AddPerson.addPersonWindow("Member"));
        Button viewMembersButton = new Button("View Members");
        viewMembersButton.setOnAction(e -> {});
        Button addClassButton = new Button("Add Class");
        addClassButton.setOnAction(e -> AddClass.addClassWindow());
        Button viewClassesButton = new Button("View Classes");
        viewClassesButton.setOnAction(e -> {});
        Button registerButton = new Button("Register Member for Class");
        registerButton.setOnAction(e -> RegisterMemberForClass.registerWindow());
        Button cancelButton = new Button("Cancel Registration");
        cancelButton.setOnAction(e -> CancelRegistration.cancelRegistrationWindow());
        Button viewRegistrationsButton = new Button("View Registrations");
        viewRegistrationsButton.setOnAction(e -> {});
        Button LogoutButton = new Button("Logout");
        LogoutButton.setOnAction(e -> {});

        VBox trainerRoleMenuLayout = new VBox(20, addMemberButton, viewMembersButton, addClassButton, viewClassesButton, registerButton, cancelButton, viewRegistrationsButton, LogoutButton);
        trainerRoleMenuLayout.setAlignment(Pos.CENTER);

        Scene trainerRoleMenuScene = new Scene(trainerRoleMenuLayout, 400, 700);

        Stage TrainerRoleMenuWindow = new Stage();
        TrainerRoleMenuWindow.setTitle("Trainer Role Menu");
        TrainerRoleMenuWindow.setScene(trainerRoleMenuScene);
        TrainerRoleMenuWindow.show();
    }
}