package GUI;

import database.DataHandler;
import database.Entry;
import database.FileHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Liste {
    private static DataHandler dh;
    public static void show(Stage primaryStage) {
        TableView tabelle = new TableView();
        String error = "";
        tabelle.setMinWidth(600);
        tabelle.setMinHeight(300);
        tabelle.setEditable(true);
        tabelle.getSelectionModel().cellSelectionEnabledProperty().set(true);
        TableColumn<Entry, String> firstname = new TableColumn<>("Vorname");
        firstname.setMinWidth(40);
        TableColumn<Entry, String> lastname = new TableColumn<>("Nachname");
        TableColumn<Entry, String> phone = new TableColumn<>("Telefonnummer");
        TableColumn<Entry, String> street = new TableColumn<>("Straße");
        TableColumn<Entry, String> hn = new TableColumn<>("Hausnummer");
        TableColumn<Entry, String> town = new TableColumn<>("Stadt");
        TableColumn<Entry, String> plz = new TableColumn<>("PLZ");

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
        search.setPromptText("Suchen...");
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
        Functions.update(tabelle, firstname, lastname, phone, street, hn, town, plz);
        search.setOnKeyReleased(keyEvent ->{
            Functions.updateSearch(tabelle, firstname, lastname, phone, street, hn, town, plz, search, checkf, checkl, checkpn, checks, checkh, checkt, checkplz);
        });
        firstname.setCellFactory(TextFieldTableCell.forTableColumn());
        firstname.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entry, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Entry, String> event) {
                if(event.getNewValue().matches("((\\w|Ä|ä|Ö|ö|Ü|ü|ß)-?)*\\w")) {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setFirstname(event.getNewValue());
                    FileHandler.saveFile();
                } else {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setFirstname(event.getOldValue());
                }
                Functions.update(tabelle, firstname, lastname, phone, street, hn, town, plz);
            }
        });
        lastname.setCellFactory(TextFieldTableCell.forTableColumn());
        lastname.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entry, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Entry, String> event) {
                if(event.getNewValue().matches("((\\w|Ä|ä|Ö|ö|Ü|ü|ß)-?)*\\w")) {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setLastname(event.getNewValue());
                    FileHandler.saveFile();
                } else {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setFirstname(event.getOldValue());
                }
                Functions.update(tabelle, firstname, lastname, phone, street, hn, town, plz);
            }
        });
        phone.setCellFactory(TextFieldTableCell.forTableColumn());
        phone.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entry, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Entry, String> event) {
                if(event.getNewValue().matches("(((\\+|((00)|(\\(00\\)) ?))\\d{1,3} ?)|(0 ?))?((((\\d{1,4})|((\\d{2} \\d{2}){1,2}))( \\d)? ?/? ?((\\d{1,20})|(\\d{2}( \\d{2}){1,4}( \\d)?))(-\\d{2,8})?)|(\\d{2}(.\\d{2}){1,4}))")) {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setPhonenumber(event.getNewValue());
                    FileHandler.saveFile();
                } else {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setFirstname(event.getOldValue());
                }
                Functions.update(tabelle, firstname, lastname, phone, street, hn, town, plz);
            }
        });
        street.setCellFactory(TextFieldTableCell.forTableColumn());
        street.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entry, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Entry, String> event) {
                if(event.getNewValue().matches("((\\w|Ä|ä|Ö|ö|Ü|ü|ß)-?)*\\w")) {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setStreet(event.getNewValue());
                    FileHandler.saveFile();
                } else {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setFirstname(event.getOldValue());
                }
                Functions.update(tabelle, firstname, lastname, phone, street, hn, town, plz);
            }
        });
        hn.setCellFactory(TextFieldTableCell.forTableColumn());
        hn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entry, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Entry, String> event) {
                if(event.getNewValue().matches("\\d+\\w?")) {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setHousenumber(event.getNewValue());
                    FileHandler.saveFile();
                } else {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setFirstname(event.getOldValue());
                }
                Functions.update(tabelle, firstname, lastname, phone, street, hn, town, plz);
            }
        });
        town.setCellFactory(TextFieldTableCell.forTableColumn());
        town.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entry, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Entry, String> event) {
                if(event.getNewValue().matches("((\\w|Ä|ä|Ö|ö|Ü|ü|ß)-?)*\\w")) {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setTown(event.getNewValue());
                    FileHandler.saveFile();
                } else {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setFirstname(event.getOldValue());
                }
                Functions.update(tabelle, firstname, lastname, phone, street, hn, town, plz);
            }
        });
        plz.setCellFactory(TextFieldTableCell.forTableColumn());
        plz.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entry, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Entry, String> event) {
                if(event.getNewValue().matches("\\d{4,6}")) {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setPostcode(event.getNewValue());
                    FileHandler.saveFile();
                } else {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setFirstname(event.getOldValue());
                }
                Functions.update(tabelle, firstname, lastname, phone, street, hn, town, plz);
            }
        });
        StackPane List = new StackPane();
        Scene ListScene = new Scene(List, 800, 400);

        Stage ListWindow = new Stage();
        ListWindow.setTitle("Liste");
        ListWindow.setScene(ListScene);

        ListWindow.setX(primaryStage.getX() + 200);
        ListWindow.setY(primaryStage.getY() + 100);

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
        StackPane.setAlignment(search, Pos.TOP_LEFT);
        StackPane.setAlignment(tabelle, Pos.TOP_LEFT);
        StackPane.setAlignment(checkf, Pos.TOP_LEFT);
        StackPane.setAlignment(checkl, Pos.TOP_LEFT);
        StackPane.setAlignment(checkpn, Pos.TOP_LEFT);
        StackPane.setAlignment(checks, Pos.TOP_LEFT);
        StackPane.setAlignment(checkh, Pos.TOP_LEFT);
        StackPane.setAlignment(checkt, Pos.TOP_LEFT);
        StackPane.setAlignment(checkplz, Pos.TOP_LEFT);
        /*StackPane.setMargin(search, new Insets(0,600,370,0));
        StackPane.setMargin(tabelle, new Insets(30,0,0,0));
        StackPane.setMargin(checkf, new Insets(0,400,370,0));
        StackPane.setMargin(checkl, new Insets(0,230,370,0));
        StackPane.setMargin(checkpn, new Insets(0,30,370,0));
        StackPane.setMargin(checks, new Insets(0,0,370,150));
        StackPane.setMargin(checkh, new Insets(0,0,370,320));
        StackPane.setMargin(checkt, new Insets(0,0,370,490));
        StackPane.setMargin(checkplz, new Insets(0,0,370,600));*/
        StackPane.setMargin(search, new Insets(5,0,0,5));
        StackPane.setMargin(tabelle, new Insets(35,0,0,0));
        StackPane.setMargin(checkf, new Insets(7,0,0,120));
        StackPane.setMargin(checkl, new Insets(7,0,0,210));
        StackPane.setMargin(checkpn, new Insets(7,0,0,310));
        StackPane.setMargin(checks, new Insets(7,0,0,440));
        StackPane.setMargin(checkh, new Insets(7,0,0,520));
        StackPane.setMargin(checkt, new Insets(7,0,0,640));
        StackPane.setMargin(checkplz, new Insets(7,0,0,720));

        ListWindow.show();

        Exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ListWindow.hide();
            }
        });
    }
}
