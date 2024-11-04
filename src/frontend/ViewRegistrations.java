package frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ViewRegistrations {
    public static void display() {
        TableView<ClassesFrontend.RegistrationFrontend> memberTable = new TableView<>();

        TableColumn<ClassesFrontend.RegistrationFrontend, String> memberIdColumn = new TableColumn<>("Member ID");
        memberIdColumn.setMinWidth(50);
        memberIdColumn.setCellValueFactory(new PropertyValueFactory<>("classID"));

        TableColumn<ClassesFrontend.RegistrationFrontend, String> classIdColumn = new TableColumn<>("Class ID");
        classIdColumn.setMinWidth(100);
        classIdColumn.setCellValueFactory(new PropertyValueFactory<>("classID"));

        TableColumn<ClassesFrontend.RegistrationFrontend, LocalDate> localDateColumn = new TableColumn<>("Registration Date");
        localDateColumn.setMinWidth(100);
        localDateColumn.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));

        TableColumn<ClassesFrontend.RegistrationFrontend, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        memberTable.setItems(getRegistrations());
        memberTable.getColumns().addAll(memberIdColumn, classIdColumn, localDateColumn, statusColumn);

        VBox memberTableLayout = new VBox(memberTable);

        Scene memberTableScene = new Scene(memberTableLayout);

        Stage memberTableWindow = new Stage();
        memberTableWindow.setTitle("View Registrations");
        memberTableWindow.setScene(memberTableScene);
        memberTableWindow.show();
    }

    public static ObservableList<ClassesFrontend.RegistrationFrontend> getRegistrations() {
        ObservableList<ClassesFrontend.RegistrationFrontend> registrations = FXCollections.observableArrayList();
        registrations.addAll(ClassesFrontend.RegistrationFrontend.getRegistrationsFromBackend());
        return registrations;
    }

}