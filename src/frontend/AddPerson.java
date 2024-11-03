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

public class AddPerson {
    public static void addPersonWindow(String type) {
        Stage addPersonWindow = new Stage();
        addPersonWindow.setTitle("Add " + type);

        Label idLabel = new Label("ID");
        Label nameLabel = new Label("Name");
        Label emailLabel = new Label("Email");
        Label phoneNumberLabel = new Label("Phone Number");
        Label specialityLabel = new Label("Speciality");
        Label membershipLabel = new Label("Membership");
        Label statusLabel = new Label("Status");

        TextField idTextField = new TextField();
        TextField nameTextField = new TextField();
        TextField emailTextField = new TextField();
        TextField phoneNumberTextField = new TextField();
        TextField specialityTextField = new TextField();
        TextField membershipTextField = new TextField();
        TextField statusTextField = new TextField();

        GridPane addPersonGridLayout = new GridPane();
        addPersonGridLayout.add(idLabel, 0, 0);
        addPersonGridLayout.add(idTextField, 1, 0);
        addPersonGridLayout.add(nameLabel, 0, 1);
        addPersonGridLayout.add(nameTextField, 1, 1);
        addPersonGridLayout.add(emailLabel, 0, 2);
        addPersonGridLayout.add(emailTextField, 1, 2);
        addPersonGridLayout.add(phoneNumberLabel, 0, 3);
        addPersonGridLayout.add(phoneNumberTextField, 1, 3);
        if (type.equals("Trainer")) {
            addPersonGridLayout.add(specialityLabel, 0, 4);
            addPersonGridLayout.add(specialityTextField, 1, 4);
        } else if (type.equals("Member")) {
            addPersonGridLayout.add(membershipLabel, 0, 5);
            addPersonGridLayout.add(membershipTextField, 1, 5);
            addPersonGridLayout.add(statusLabel, 0, 6);
            addPersonGridLayout.add(statusTextField, 1, 6);
        } else {
            System.out.println("Wrong type");
        }
        addPersonGridLayout.setAlignment(Pos.CENTER);
        addPersonGridLayout.setHgap(15);
        addPersonGridLayout.setVgap(15);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            if (!idTextField.getText().isEmpty() && !nameTextField.getText().isEmpty() && !emailTextField.getText().isEmpty() && !phoneNumberTextField.getText().isEmpty()) {
                if (type.equals("Trainer")) {
                    if (!specialityTextField.getText().isEmpty()) {
                        if (Main.addTrainerFromFrontend(idTextField.getText(), nameTextField.getText(), emailTextField.getText(), phoneNumberTextField.getText(), specialityTextField.getText())) {
                            AlertBox.display("Trainer Added", "The Trainer with ID = " + idTextField.getText() + " has been added successfully.");
                            addPersonWindow.close();
                        } else {
                            AlertBox.display("Already Exist", "The Trainer with ID = " + idTextField.getText() + " already exists.");
                        }
                    } else
                        AlertBox.display("Empty Fields", "Some Fields are Empty!!");
                } else if (type.equals("Member"))
                    if (!membershipLabel.getText().isEmpty() && !statusTextField.getText().isEmpty()) {
                        if (Main.addMemberFromFrontend(idTextField.getText(), nameTextField.getText(), membershipTextField.getText(), emailTextField.getText(), phoneNumberTextField.getText(), statusTextField.getText())) {
                            AlertBox.display("Member Added", "The Member with ID = " + idTextField.getText() + " has been added successfully.");
                            addPersonWindow.close();
                        }
                        else {
                            AlertBox.display("Already Exist", "The Member with ID = " + idTextField.getText() + " already exists.");
                        }
                    } else
                        AlertBox.display("Empty Fields", "Some Fields are Empty!!");
                else {
                    System.out.println("Wrong type");
                }
            } else {
                AlertBox.display("Empty Fields", "Some Fields are Empty!!");
            }
        });

        VBox addPersonFinalLayout = new VBox();
        addPersonFinalLayout.getChildren().addAll(addPersonGridLayout, addButton);
        addPersonFinalLayout.setAlignment(Pos.CENTER);
        addPersonFinalLayout.setSpacing(30);

        Scene addPersonScene = new Scene(addPersonFinalLayout, 400, 400);
        addPersonWindow.setScene(addPersonScene);
        addPersonWindow.show();

    }
}
