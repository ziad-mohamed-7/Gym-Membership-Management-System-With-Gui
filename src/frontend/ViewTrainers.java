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
        idColumn.setCellValueFactory(new PropertyValueFactory<>("trainerID"));

        TableColumn<Trainer, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Trainer, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Trainer, String> specialityColumn = new TableColumn<>("Speciality");
        specialityColumn.setCellValueFactory(new PropertyValueFactory<>("speciality"));

        TableColumn<Trainer, String> phoneNumberColumn = new TableColumn<>("Phone Number");
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

        trainers.add(new Trainer("vuyv", "vuyv", "vuyv", "vuyv", "vuyv"));
        trainers.add(new Trainer("pkmyv", "vugerw", "gevuyv", "erwrv", "Asdf"));
//        for (Trainer trainer:Main.getListOfTrainersForFrontend()){
//            System.out.println(trainer.lineRepresentation());
//        }
        return trainers;
    }

}
