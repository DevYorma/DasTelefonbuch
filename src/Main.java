import database.DataHandler;
import database.Entry;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

public class Main extends Application {
    private DataHandler dh;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        //DataHandler.addEntry(new Entry("Emil", "Müller", "67435", "Zum Träumen", "1a", "Musterstadt", 12345));
        //DataHandler.addEntry(new Entry("Maria", "Müller", "67435", "Zum Träumen", "1a", "Musterstadt", 12345));
        Parent root = FXMLLoader.load(getClass().getResource("style.fxml"));
        //Button btn = new Button();
        //btn.setText("Change String");
        Label lbl = new Label();
        lbl.setWrapText(true);
        lbl.setText("Willkommen bei der DasTelefonbuch Software");
        primaryStage.setTitle("DasTelefonbuch Menü");
        StackPane.setMargin(lbl, new Insets(0, 0, 80, 0));
        //StackPane.setMargin(btn, new Insets(0,250 , 0,0 ));


        Button newWindow = new Button();
        newWindow.setText("Editor");
        StackPane.setMargin(newWindow, new Insets(0, 0, 0, 0));
        newWindow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label lblf = new Label("Vorname: ");
                Label lbll = new Label("Nachname: ");
                Label lblp = new Label("Telefon: ");
                Label lbls = new Label("Straße: ");
                Label lblh = new Label("Hausnummer: ");
                Label lblt = new Label("Ort: ");
                Label lblpl = new Label("PLZ: ");

                TextField txtf = new TextField();
                txtf.setMaxWidth(100);
                TextField txtl = new TextField();
                txtl.setMaxWidth(100);
                TextField txtp = new TextField();
                txtp.setMaxWidth(100);
                TextField txts = new TextField();
                txts.setMaxWidth(100);
                TextField txth = new TextField();
                txth.setMaxWidth(100);
                TextField txtt = new TextField();
                txtt.setMaxWidth(100);
                TextField txtpl = new TextField();
                txtpl.setMaxWidth(100);

                Button Exit2 = new Button();
                Exit2.setText("Zurück");
                Button save = new Button();
                save.setText("Speichern");
                Label worked = new Label("");
                StackPane secondLayout = new StackPane();
                secondLayout.getChildren().addAll(lblf, lblh, lbll, lblp, lbls, lblt, lblpl, txtf, txtl,txtp,txts,txth,txtt,txtpl, worked);
                secondLayout.getChildren().addAll(Exit2,save);
                StackPane.setMargin(Exit2, new Insets(350,540,0,0));
                StackPane.setMargin(save, new Insets(190,0,0,0));
                StackPane.setMargin(worked, new Insets(250,0,0,0));


                StackPane.setMargin(lblf, new Insets(0,200,300,0));
                StackPane.setMargin(lbll, new Insets(0,200,230,0));
                StackPane.setMargin(lblp, new Insets(0,200,160,0));
                StackPane.setMargin(lbls, new Insets(0,200,90,0));
                StackPane.setMargin(lblh, new Insets(0,200,20,0));
                StackPane.setMargin(lblt, new Insets(50,200,0,0));
                StackPane.setMargin(lblpl, new Insets(120,200,0,0));

                StackPane.setMargin(txtf, new Insets(0,0,300,0));
                StackPane.setMargin(txtl, new Insets(0,0,230,0));
                StackPane.setMargin(txtp, new Insets(0,0,160,0));
                StackPane.setMargin(txts, new Insets(0,0,90,0));
                StackPane.setMargin(txth, new Insets(0,0,20,0));
                StackPane.setMargin(txtt, new Insets(50,0,0,0));
                StackPane.setMargin(txtpl, new Insets(120,0,0,0));

                Scene secondScene = new Scene(secondLayout, 600, 400);

                //New Window (Stage)
                Stage Window = new Stage();
                Window.setTitle("Edit");
                Window.setScene(secondScene);

                //Position of the Window
                Window.setX(primaryStage.getX() + 200);
                Window.setY(primaryStage.getY() + 100);

                Window.show();

                save.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(txtf.getText().length() != 0 && txtl.getText().length() != 0 && txtp.getText().length() != 0 && txts.getText().length() != 0 && txtt.getText().length() != 0 && txtpl.getText().length() != 0) {
                            dh.addEntry(new Entry(txtf.getText(), txtl.getText(), txtp.getText(), txts.getText(), txth.getText(), txtt.getText(), txtpl.getText()));
                            txtf.clear();
                            txth.clear();
                            txtl.clear();
                            txtp.clear();
                            txtpl.clear();
                            txts.clear();
                            txtt.clear();
                            worked.setText("Ihr Kontakt wurde gespeichert!");
                        }else{
                            worked.setText("Bitte Überprüfen sie ihre eingabe");
                        }
                    }
                });

                Exit2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Window.hide();
                    }
                });
            }
        });

        Button btnList = new Button();
        btnList.setText("Liste");
        StackPane.setMargin(btnList, new Insets(0, 251, 0, 0));
        btnList.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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
                checkf.setText("Vorname");
                CheckBox checkl = new CheckBox();
                checkl.setText("Nachname");
                CheckBox checkpn = new CheckBox();
                checkpn.setText("Telefonnummer");
                CheckBox checks = new CheckBox();
                checks.setText("Straße");
                CheckBox checkh = new CheckBox();
                checkh.setText("Hausnummer");
                CheckBox checkt = new CheckBox();
                checkt.setText("Stadt");
                CheckBox checkplz = new CheckBox();
                checkplz.setText("PLZ");
                TextField search = new TextField();
                search.setPromptText("Suchen!");
                search.setMaxWidth(100);
                Exit.setText("Zurück");
                ObservableList<Entry> data = FXCollections.observableArrayList(dh.getEntries());
                ObservableList<Entry> searchlist = null;
                for(Entry entry : data){
                    firstname.setCellValueFactory(new PropertyValueFactory<> ("firstname"));
                    lastname.setCellValueFactory(new PropertyValueFactory<> ("lastname"));
                    phone.setCellValueFactory(new PropertyValueFactory<> ("phonenumber"));
                    street.setCellValueFactory(new PropertyValueFactory<> ("street"));
                    hn.setCellValueFactory(new PropertyValueFactory<> ("housenumber"));
                    town.setCellValueFactory(new PropertyValueFactory<> ("town"));
                    plz.setCellValueFactory(new PropertyValueFactory<> ("postcode"));
                }
                tabelle.setItems(data);
                search.setOnKeyReleased(keyEvent ->{
                    checkf.isSelected();
                    for(Entry entry : data) {
                        if(!searchlist.contains(entry)) {
                            if(checkf.isSelected()) {
                                if(entry.getFirstname().toLowerCase().contains(search.getText().toLowerCase()))
                                    searchlist.add(entry);
                            }
                        }
                        if(!searchlist.contains(entry)) {
                            if(checkl.isSelected()) {
                                if(entry.getLastname().toLowerCase().contains(search.getText().toLowerCase()))
                                    searchlist.add(entry);
                            }
                        }
                        if(!searchlist.contains(entry)) {
                            if(checkpn.isSelected()) {
                                if(entry.getPhonenumber().toLowerCase().contains(search.getText().toLowerCase()))
                                    searchlist.add(entry);
                            }
                        }
                        if(!searchlist.contains(entry)) {
                            if(checks.isSelected()) {
                                if(entry.getStreet().toLowerCase().contains(search.getText().toLowerCase()))
                                    searchlist.add(entry);
                            }
                        }
                        if(!searchlist.contains(entry)) {
                            if(checkh.isSelected()) {
                                if(entry.getHousenumber().toLowerCase().contains(search.getText().toLowerCase()))
                                    searchlist.add(entry);
                            }
                        }
                        if(!searchlist.contains(entry)) {
                            if(checkt.isSelected()) {
                                if(entry.getTown().toLowerCase().contains(search.getText().toLowerCase()))
                                    searchlist.add(entry);
                            }
                        }
                        if(!searchlist.contains(entry)) {
                            if(checkplz.isSelected()) {
                                if(entry.getPostcode().toLowerCase().contains(search.getText().toLowerCase()))
                                    searchlist.add(entry);
                            }
                        }
                    }
                    tabelle.setItems(searchlist);

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
                StackPane.setMargin(search, new Insets(0,500,370,0));
                StackPane.setMargin(tabelle, new Insets(30,0,0,0));
                StackPane.setMargin(checkf, new Insets(0,300,370,0));
                Scene ListScene = new Scene(List, 600, 400);

                Stage ListWindow = new Stage();
                ListWindow.setTitle("Liste");
                ListWindow.setScene(ListScene);

                ListWindow.setX(primaryStage.getX() + 200);
                ListWindow.setY(primaryStage.getY() + 100);

                ListWindow.show();

                Exit.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ListWindow.hide();
                    }
                });
            }
        });

        Button Close = new Button();
        Close.setText("Exit");
        StackPane.setMargin(Close, new Insets(0,0,0,250));
        Close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        StackPane sp = new StackPane();
        sp.getChildren().add(newWindow);
        //sp.getChildren().add(btn);
        sp.getChildren().add(lbl);
        sp.getChildren().add(btnList);
        sp.getChildren().add(Close);
        primaryStage.setScene(new Scene(sp, 400, 120));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
