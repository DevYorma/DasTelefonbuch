
import database.DataHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Stack;

//Max riecht nach Croissants

public class Main extends Application {
    private DataHandler dh;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("style.fxml"));
        Button btn = new Button();
        btn.setText("Change String");
        Label lbl = new Label();
        lbl.setWrapText(true);
        lbl.setText("Hallo");
        primaryStage.setTitle("DasTelefonbuch Menü");
        StackPane.setMargin(lbl, new Insets(0, 0, 0, 0));
        StackPane.setMargin(btn, new Insets(0, 450, 300,0 ));

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lbl.setText("Hello World");
            }
        });

        Button newWindow = new Button();
        newWindow.setText("Editor");
        StackPane.setMargin(newWindow, new Insets(0, 0, 300, 500));
        newWindow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Label lbl2 = new Label("Oh look it worked");
                Button Exit2 = new Button();
                Exit2.setText("Zurück");
                StackPane secondLayout = new StackPane();
                secondLayout.getChildren().add(lbl2);
                secondLayout.getChildren().add(Exit2);
                StackPane.setMargin(Exit2, new Insets(340, 500, 0, 0));

                Scene secondScene = new Scene(secondLayout, 600, 400);

                //New Window (Stage)
                Stage Window = new Stage();
                Window.setTitle("Edit");
                Window.setScene(secondScene);

                //Position of the Window
                Window.setX(primaryStage.getX() + 200);
                Window.setY(primaryStage.getY() + 100);

                Window.show();

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
        StackPane.setMargin(btnList, new Insets(300, 0, 0, 500));
        btnList.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label lbl3 = new Label("Hier ist die Liste, NR.1: Noch niemand");
                Button Exit = new Button();
                Exit.setText("Zurück");

                StackPane List = new StackPane();
                List.getChildren().add(lbl3);
                StackPane.setMargin(lbl3, new Insets(0,400,380,0));
                List.getChildren().add(Exit);
                StackPane.setMargin(Exit, new Insets(340,500,0,0));

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
        StackPane.setMargin(Close, new Insets(300,500,0,0));
        Close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        StackPane sp = new StackPane();
        sp.getChildren().add(newWindow);
        sp.getChildren().add(btn);
        sp.getChildren().add(lbl);
        sp.getChildren().add(btnList);
        sp.getChildren().add(Close);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
