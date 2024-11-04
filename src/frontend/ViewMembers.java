package frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewMembers {
    public static void display() {
        TableView<ClassesFrontend.MemberFrontend> memberTable = new TableView<>();

        TableColumn<ClassesFrontend.MemberFrontend, String> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(50);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("memberID"));

        TableColumn<ClassesFrontend.MemberFrontend, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<ClassesFrontend.MemberFrontend, String> membershipTypeColumn = new TableColumn<>("Membership Type");
        membershipTypeColumn.setMinWidth(100);
        membershipTypeColumn.setCellValueFactory(new PropertyValueFactory<>("membershipType"));

        TableColumn<ClassesFrontend.MemberFrontend, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(100);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<ClassesFrontend.MemberFrontend, String> phoneNumberColumn = new TableColumn<>("Phone Number");
        phoneNumberColumn.setMinWidth(100);
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<ClassesFrontend.MemberFrontend, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        memberTable.setItems(getMembers());
        memberTable.getColumns().addAll(idColumn, nameColumn, emailColumn, membershipTypeColumn, phoneNumberColumn, statusColumn);

        VBox memberTableLayout = new VBox(memberTable);

        Scene memberTableScene = new Scene(memberTableLayout);

        Stage memberTableWindow = new Stage();
        memberTableWindow.setTitle("View Members");
        memberTableWindow.setScene(memberTableScene);
        memberTableWindow.show();
    }

    public static ObservableList<ClassesFrontend.MemberFrontend> getMembers() {
        ObservableList<ClassesFrontend.MemberFrontend> members = FXCollections.observableArrayList();
        members.addAll(ClassesFrontend.MemberFrontend.getMembersFromBackend());
        return members;
    }

}
