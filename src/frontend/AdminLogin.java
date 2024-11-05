package frontend;

import constants.LoginCredentials;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminLogin implements LoginCredentials {

    public static void display() {
        Stage adminLoginWindow = new Stage();
        adminLoginWindow.setTitle("Admin Login");

        Label userNameLabel = new Label("Username: ");
        Label passwordLabel = new Label("Password: ");

        TextField userNameTextField = new TextField();
        PasswordField passwordTextField = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            if (userNameTextField.getText().equals(ADMIN_USERNAME) && passwordTextField.getText().equals(ADMIN_PASSWORD)) {
                AdminRoleMenu.display();
                adminLoginWindow.close();
            }
            else
                AlertBox.display("Wrong Credentials", "Wrong Username or Password", true);
        });

        GridPane adminLoginGridLayout = new GridPane();
        adminLoginGridLayout.add(userNameLabel, 0, 0);
        adminLoginGridLayout.add(userNameTextField, 1, 0);
        adminLoginGridLayout.add(passwordLabel, 0, 1);
        adminLoginGridLayout.add(passwordTextField, 1, 1);
        adminLoginGridLayout.setAlignment(Pos.CENTER);
        adminLoginGridLayout.setHgap(10);
        adminLoginGridLayout.setVgap(20);

        VBox adminLoginFinalLayout = new VBox(20);
        adminLoginFinalLayout.getChildren().addAll(adminLoginGridLayout, loginButton);
        adminLoginFinalLayout.setAlignment(Pos.CENTER);

        Scene adminLoginScene = new Scene(adminLoginFinalLayout, 400, 400);
        adminLoginScene.getStylesheets().add(AdminLogin.class.getResource("styles.css").toExternalForm());

        adminLoginWindow.setScene(adminLoginScene);
        adminLoginWindow.show();
    }
}