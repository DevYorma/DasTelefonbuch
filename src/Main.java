import GUI.Editor;
import GUI.Functions;
import GUI.Liste;
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
                Editor.show(primaryStage);
            }
        });

        Button btnList = new Button();
        btnList.setText("Liste");
        StackPane.setMargin(btnList, new Insets(0, 251, 0, 0));
        btnList.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Liste.show(primaryStage);
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
