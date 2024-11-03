package frontend;

import backend.Main;
import backend.Trainer;
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
        TableView<Trainer> trainerTable = new TableView<>();

        TableColumn<Trainer, String> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(50);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("trainerID"));

        TableColumn<Trainer, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Trainer, String> emailColumn = new TableColumn<>("Email");
        nameColumn.setMinWidth(100);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Trainer, String> specialityColumn = new TableColumn<>("Speciality");
        nameColumn.setMinWidth(100);
        specialityColumn.setCellValueFactory(new PropertyValueFactory<>("specialty"));

        TableColumn<Trainer, String> phoneNumberColumn = new TableColumn<>("Phone Number");
        nameColumn.setMinWidth(100);
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

    public static ObservableList<Trainer> getTrainers() {
        ObservableList<Trainer> trainers = FXCollections.observableArrayList();
        trainers.addAll(Main.getListOfTrainersForFrontend());
        return trainers;
    }

}
