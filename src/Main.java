import com.sun.javafx.event.CompositeEventTarget;
import database.DataHandler;
import database.Entry;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

import javax.xml.soap.Text;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        StackPane.setMargin(lbl, new Insets(0,0,100,0));
        lbl.setWrapText(true);
        lbl.setText("Willkommen bei der DasTelefonbuch Software");
        primaryStage.setTitle("DasTelefonbuch Menü");
        //StackPane.setMargin(btn, new Insets(0,250 , 0,0 ));


        Button newWindow = new Button();
        StackPane.setMargin(newWindow, new Insets(0,280,0,0));
        newWindow.setText("Editor");
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
                Window.setResizable(false);

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
                            worked.setText("Bitte Überprüfen sie ihre Eingabe");
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
        StackPane.setMargin(btnList, new Insets(0,0,0,0));
        btnList.setText("Liste");
        btnList.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //DataHandler.addEntry(new Entry("Emil", "Müller", "67435", "Zum Träumen", "1a", "Musterstadt", "12345"));
                //DataHandler.addEntry(new Entry("Maria", "Müller", "67435", "Zum Träumen", "1a", "Musterstadt", "12346"));
                TableView tabelle = new TableView();
                tabelle.setMinWidth(600);
                tabelle.setMinHeight(300);
                TableColumn firstname = new TableColumn("Vorname");
                firstname.setMinWidth(40);
                TableColumn lastname = new TableColumn("Nachname");
                TableColumn phone = new TableColumn("Telefonnummer");
                TableColumn street = new TableColumn("Straße");
                TableColumn hn = new TableColumn("Hausnummer");
                TableColumn town = new TableColumn("Stadt");
                TableColumn plz = new TableColumn("PLZ");
                //Label lbl3 = new Label("Hier ist die Liste, NR.1: Noch niemand");
                Button Exit = new Button();
                Exit.setText("Zurück");
                ObservableList<Entry> data = FXCollections.observableArrayList(dh.getEntries());
                for(Entry entry : data){
                    firstname.setCellValueFactory(new PropertyValueFactory<> ("firstname"));
                    lastname.setCellValueFactory(new PropertyValueFactory<> ("lastname"));
                    phone.setCellValueFactory(new PropertyValueFactory<> ("phonenumber"));
                    street.setCellValueFactory(new PropertyValueFactory<> ("street"));
                    hn.setCellValueFactory(new PropertyValueFactory<> ("housenumber"));
                    town.setCellValueFactory(new PropertyValueFactory<> ("town"));
                    plz.setCellValueFactory(new PropertyValueFactory<> ("postcode"));
                }


                CheckBox checkf = new CheckBox();
                CheckBox checkl = new CheckBox();
                CheckBox checkp = new CheckBox();
                CheckBox checks = new CheckBox();
                CheckBox checkh = new CheckBox();
                CheckBox checkt = new CheckBox();
                CheckBox checkpl = new CheckBox();
                checkf.setText("Vorname");
                TextField search = new TextField();
                search.setPromptText("Suchen!");
                search.setMaxWidth(100);
                search.setOnKeyReleased(keyEvent ->{
                    checkf.isSelected();


                });

                Button del = new Button();
                del.setText("X");
                del.setPrefWidth(30);
                del.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                    }
                });

                StackPane List = new StackPane();
                //List.getChildren().add(lbl3);
                //StackPane.setMargin(lbl3, new Insets(0,400,380,0));
                List.getChildren().add(Exit);
                StackPane.setMargin(Exit, new Insets(340,500,0,0));
                tabelle.setItems(data);
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
                ListWindow.setResizable(false);
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
        StackPane.setMargin(Close, new Insets(0,0,0,280));
        Close.setText("Exit");
        Close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        StackPane sp = new StackPane();
        sp.getChildren().add(newWindow);
        sp.getChildren().add(btnList);
        sp.getChildren().add(lbl);
        sp.getChildren().add(Close);
        primaryStage.setScene(new Scene(sp, 400, 120));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
