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

public class TrainerLogin implements LoginCredentials {

    public static void display() {
        Stage trainerLoginWindow = new Stage();

        Label userNameLabel = new Label("Username: ");
        Label passwordLabel = new Label("Password: ");

        TextField userNameTextField = new TextField();
        PasswordField passwordTextField = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            if (userNameTextField.getText().equals(TRAINER_USERNAME) && passwordTextField.getText().equals(TRAINER_PASSWORD)) {
                TrainerRoleMenu.display();
                trainerLoginWindow.close();
            }
            else
                AlertBox.display("Wrong Credentials", "Wrong Username or Password");
        });


        GridPane trainerLoginGridLayout = new GridPane();
        trainerLoginGridLayout.add(userNameLabel, 0, 0);
        trainerLoginGridLayout.add(userNameTextField, 1, 0);
        trainerLoginGridLayout.add(passwordLabel, 0, 1);
        trainerLoginGridLayout.add(passwordTextField, 1, 1);
        trainerLoginGridLayout.setAlignment(Pos.CENTER);
        trainerLoginGridLayout.setHgap(10);
        trainerLoginGridLayout.setVgap(20);

        VBox trainerLoginFinalLayout = new VBox(20);
        trainerLoginFinalLayout.getChildren().addAll(trainerLoginGridLayout, loginButton);
        trainerLoginFinalLayout.setAlignment(Pos.CENTER);

        Scene trainerLoginScene = new Scene(trainerLoginFinalLayout, 400, 400);
        trainerLoginScene.getStylesheets().add(TrainerLogin.class.getResource("styles.css").toExternalForm());

        trainerLoginWindow.setScene(trainerLoginScene);
        trainerLoginWindow.show();
    }
}