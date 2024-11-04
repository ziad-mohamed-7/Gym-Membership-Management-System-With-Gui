package frontend;

import backend.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrainerRoleMenu {
    public static void display() {
        Stage trainerRoleMenuWindow = new Stage();
        trainerRoleMenuWindow.setTitle("Trainer Role Menu");

        Button addMemberButton = new Button("Add Member");
        addMemberButton.setOnAction(e -> AddPerson.addPersonWindow("Member"));

        Button viewMembersButton = new Button("View Members");
        viewMembersButton.setOnAction(e -> ViewMembers.display());

        Button addClassButton = new Button("Add Class");
        addClassButton.setOnAction(e -> AddClass.addClassWindow());

        Button viewClassesButton = new Button("View Classes");
        viewClassesButton.setOnAction(e -> ViewClasses.display());

        Button registerButton = new Button("Register Member for Class");
        registerButton.setOnAction(e -> RegisterMemberForClass.registerWindow());

        Button cancelButton = new Button("Cancel Registration");
        cancelButton.setOnAction(e -> CancelRegistration.cancelRegistrationWindow());

        Button viewRegistrationsButton = new Button("View Registrations");
        viewRegistrationsButton.setOnAction(e -> ViewRegistrations.display());

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> {
            boolean result = Logout.display();
            if (result) {
                Main.trainerLogoutFromFrontend();
                trainerRoleMenuWindow.close();
            }
        });

        VBox trainerRoleMenuLayout = new VBox(17, addMemberButton, viewMembersButton, addClassButton, viewClassesButton, registerButton, cancelButton, viewRegistrationsButton, logoutButton);
        trainerRoleMenuLayout.setAlignment(Pos.CENTER);

        Scene trainerRoleMenuScene = new Scene(trainerRoleMenuLayout, 400, 400);
        trainerRoleMenuWindow.setScene(trainerRoleMenuScene);
        trainerRoleMenuWindow.show();
    }
}