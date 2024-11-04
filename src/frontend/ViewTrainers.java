package frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewTrainers {
    public static void display() {
        TableView<ClassesFrontend.TrainerFrontend> trainerTable = new TableView<>();

        TableColumn<ClassesFrontend.TrainerFrontend, String> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(50);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("trainerID"));

        TableColumn<ClassesFrontend.TrainerFrontend, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<ClassesFrontend.TrainerFrontend, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(100);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<ClassesFrontend.TrainerFrontend, String> specialityColumn = new TableColumn<>("Speciality");
        specialityColumn.setMinWidth(100);
        specialityColumn.setCellValueFactory(new PropertyValueFactory<>("specialty"));

        TableColumn<ClassesFrontend.TrainerFrontend, String> phoneNumberColumn = new TableColumn<>("Phone Number");
        phoneNumberColumn.setMinWidth(100);
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        trainerTable.setItems(getTrainers());
        trainerTable.getColumns().addAll(idColumn, nameColumn, emailColumn, specialityColumn, phoneNumberColumn);

        VBox trainerTableLayout = new VBox(trainerTable);

        Scene trainerTableScene = new Scene(trainerTableLayout);

        Stage trainerTableWindow = new Stage();
        trainerTableWindow.setTitle("View Trainers");
        trainerTableWindow.setScene(trainerTableScene);
        trainerTableWindow.show();
    }

    public static ObservableList<ClassesFrontend.TrainerFrontend> getTrainers() {
        ObservableList<ClassesFrontend.TrainerFrontend> trainers = FXCollections.observableArrayList();
        trainers.addAll(ClassesFrontend.TrainerFrontend.getTrainersFromBackend());
        return trainers;
    }
}