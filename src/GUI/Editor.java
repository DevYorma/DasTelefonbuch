package GUI;

import database.DataHandler;
import database.Entry;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Editor {
    public static void show(final Stage primaryStage) {
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
                    DataHandler.addEntry(new Entry(txtf.getText(), txtl.getText(), txtp.getText(), txts.getText(), txth.getText(), txtt.getText(), txtpl.getText()));
                    txtf.clear();
                    txth.clear();
                    txtl.clear();
                    txtp.clear();
                    txtpl.clear();
                    txts.clear();
                    txtt.clear();
                    worked.setText("Ihr Kontakt wurde gespeichert!");
                }else{
                    worked.setText("Bitte Überprüfen sie ihre Eingabe!");
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
}
