package frontend;

import constants.LoginCredentials;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrainerLogin implements LoginCredentials {

    public static void display() {
        Label userNameLabel = new Label("Username: ");
        Label passwordLabel = new Label("Password: ");

        TextField userNameTextField = new TextField();
        PasswordField passwordTextField = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            if (userNameTextField.getText().equals(TRAINER_USERNAME) && passwordTextField.getText().equals(TRAINER_PASSWORD))
                TrainerRoleMenu.display();
            else
                AlertBox.display("Wrong Credentials", "Wrong Username or Password");
        });


        VBox adminLoginLayout = new VBox();
        adminLoginLayout.getChildren().addAll(userNameLabel, passwordLabel, userNameTextField, passwordTextField, loginButton);
        adminLoginLayout.setAlignment(Pos.CENTER);

        Scene adminLoginScene = new Scene(adminLoginLayout, 400, 400);

        Stage adminLoginWindow = new Stage();
        adminLoginWindow.setTitle("Admin Login");
        adminLoginWindow.setScene(adminLoginScene);
        adminLoginWindow.show();
    }
}