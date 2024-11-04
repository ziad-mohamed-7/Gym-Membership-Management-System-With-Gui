package frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewClasses {

    public static void display() {
        TableView<ClassesFrontend.ClassFrontend> classTable = new TableView<>();

        TableColumn<ClassesFrontend.ClassFrontend, String> classIdColumn = new TableColumn<>("Class ID");
        classIdColumn.setMinWidth(50);
        classIdColumn.setCellValueFactory(new PropertyValueFactory<>("classID"));

        TableColumn<ClassesFrontend.ClassFrontend, String> classNameColumn = new TableColumn<>("Class Name");
        classNameColumn.setMinWidth(100);
        classNameColumn.setCellValueFactory(new PropertyValueFactory<>("className"));

        TableColumn<ClassesFrontend.ClassFrontend, String> trainerIdColumn = new TableColumn<>("Trainer ID");
        trainerIdColumn.setMinWidth(100);
        trainerIdColumn.setCellValueFactory(new PropertyValueFactory<>("trainerID"));

        TableColumn<ClassesFrontend.ClassFrontend, Integer> durationColumn = new TableColumn<>("Duration");
        durationColumn.setMinWidth(100);
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        TableColumn<ClassesFrontend.ClassFrontend, Integer> availableSeatsColumn = new TableColumn<>("Available Seats");
        availableSeatsColumn.setMinWidth(100);
        availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("availableSeats"));

        classTable.setItems(getClasses());
        classTable.getColumns().addAll(classIdColumn, classNameColumn, trainerIdColumn, durationColumn, availableSeatsColumn);

        VBox classTableLayout = new VBox(classTable);

        Scene classTableScene = new Scene(classTableLayout);

        Stage classTableWindow = new Stage();
        classTableWindow.setTitle("View Classes");
        classTableWindow.setScene(classTableScene);
        classTableWindow.show();
    }

    public static ObservableList<ClassesFrontend.ClassFrontend> getClasses() {
        ObservableList<ClassesFrontend.ClassFrontend> classes = FXCollections.observableArrayList();
        classes.addAll(ClassesFrontend.ClassFrontend.getClassesFromBackend());
        return classes;
    }

}