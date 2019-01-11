package GUI;

import database.DataHandler;
import database.Entry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Liste {
    private static DataHandler dh;
    public static void show(Stage primaryStage) {
        TableView tabelle = new TableView();
        tabelle.setMinWidth(600);
        tabelle.setMinHeight(300);
        TableColumn firstname = new TableColumn("Vorname");
        firstname.setMinWidth(40);
        TableColumn<Object, Object> lastname = new TableColumn<>("Nachname");
        TableColumn<Object, Object> phone = new TableColumn<>("Telefonnummer");
        TableColumn<Object, Object> street = new TableColumn<>("Straße");
        TableColumn<Object, Object> hn = new TableColumn<>("Hausnummer");
        TableColumn<Object, Object> town = new TableColumn<>("Stadt");
        TableColumn<Object, Object> plz = new TableColumn<>("PLZ");
        //Label lbl3 = new Label("Hier ist die Liste, NR.1: Noch niemand");
        Button Exit = new Button();
        CheckBox checkf = new CheckBox();
        CheckBox checkl = new CheckBox();
        CheckBox checkpn = new CheckBox();
        CheckBox checks = new CheckBox();
        CheckBox checkh = new CheckBox();
        CheckBox checkt = new CheckBox();
        CheckBox checkplz = new CheckBox();
        TextField search = new TextField();
        search.setPromptText("Suchen!");
        search.setMaxWidth(100);
        checkf.setText("Vorname");
        checkf.setSelected(true);
        checkf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Functions.updateSearch(tabelle, firstname, lastname, phone, street, hn, town, plz, search, checkf, checkl, checkpn, checks, checkh, checkt, checkplz);
            }
        });
        checkl.setText("Nachname");
        checkl.setSelected(true);
        checkl.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Functions.updateSearch(tabelle, firstname, lastname, phone, street, hn, town, plz, search, checkf, checkl, checkpn, checks, checkh, checkt, checkplz);
            }
        });
        checkpn.setText("Telefonnummer");
        checkpn.setSelected(true);
        checkpn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Functions.updateSearch(tabelle, firstname, lastname, phone, street, hn, town, plz, search, checkf, checkl, checkpn, checks, checkh, checkt, checkplz);
            }
        });
        checks.setText("Straße");
        checks.setSelected(true);
        checks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Functions.updateSearch(tabelle, firstname, lastname, phone, street, hn, town, plz, search, checkf, checkl, checkpn, checks, checkh, checkt, checkplz);
            }
        });
        checkh.setText("Hausnummer");
        checkh.setSelected(true);
        checkh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Functions.updateSearch(tabelle, firstname, lastname, phone, street, hn, town, plz, search, checkf, checkl, checkpn, checks, checkh, checkt, checkplz);
            }
        });
        checkt.setText("Stadt");
        checkt.setSelected(true);
        checkt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Functions.updateSearch(tabelle, firstname, lastname, phone, street, hn, town, plz, search, checkf, checkl, checkpn, checks, checkh, checkt, checkplz);
            }
        });
        checkplz.setText("PLZ");
        checkplz.setSelected(true);
        checkplz.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Functions.updateSearch(tabelle, firstname, lastname, phone, street, hn, town, plz, search, checkf, checkl, checkpn, checks, checkh, checkt, checkplz);
            }
        });
        Exit.setText("Zurück");
        ObservableList<Entry> data = FXCollections.observableArrayList(dh.getEntries());
        for(Entry entry : data){
            firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
            lastname.setCellValueFactory(new PropertyValueFactory<> ("lastname"));
            phone.setCellValueFactory(new PropertyValueFactory<> ("phonenumber"));
            street.setCellValueFactory(new PropertyValueFactory<> ("street"));
            hn.setCellValueFactory(new PropertyValueFactory<> ("housenumber"));
            town.setCellValueFactory(new PropertyValueFactory<> ("town"));
            plz.setCellValueFactory(new PropertyValueFactory<> ("postcode"));
        }
        tabelle.setItems(data);
        search.setOnKeyReleased(keyEvent ->{
            Functions.updateSearch(tabelle, firstname, lastname, phone, street, hn, town, plz, search, checkf, checkl, checkpn, checks, checkh, checkt, checkplz);
        });
        StackPane List = new StackPane();
        //List.getChildren().add(lbl3);
        //StackPane.setMargin(lbl3, new Insets(0,400,380,0));
        List.getChildren().add(Exit);
        StackPane.setMargin(Exit, new Insets(340,500,0,0));
        tabelle.getColumns().addAll(firstname, lastname, phone, street, hn, town, plz);
        List.getChildren().add(tabelle);
        List.getChildren().add(search);
        List.getChildren().add(checkf);
        List.getChildren().add(checkl);
        List.getChildren().add(checkpn);
        List.getChildren().add(checks);
        List.getChildren().add(checkh);
        List.getChildren().add(checkt);
        List.getChildren().add(checkplz);
        StackPane.setMargin(search, new Insets(0,600,370,0));
        StackPane.setMargin(tabelle, new Insets(30,0,0,0));
        StackPane.setMargin(checkf, new Insets(0,400,370,0));
        StackPane.setMargin(checkl, new Insets(0,230,370,0));
        StackPane.setMargin(checkpn, new Insets(0,30,370,0));
        StackPane.setMargin(checks, new Insets(0,0,370,150));
        StackPane.setMargin(checkh, new Insets(0,0,370,320));
        StackPane.setMargin(checkt, new Insets(0,0,370,490));
        StackPane.setMargin(checkplz, new Insets(0,0,370,600));
        Scene ListScene = new Scene(List, 800, 400);

        Stage ListWindow = new Stage();
        ListWindow.setTitle("Liste");
        ListWindow.setScene(ListScene);

        ListWindow.setX(primaryStage.getX() + 200);
        ListWindow.setY(primaryStage.getY() + 100);
        ListWindow.setResizable(false);
        ListWindow.show();

        Exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ListWindow.hide();
            }
        });
    }
}
