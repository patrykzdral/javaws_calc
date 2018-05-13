package com.pwr.patrykzdral.calc.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calc extends Application {

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getClassLoader().getResource("fxml/main.fxml"));
            loader.load();
            Parent root = loader.getRoot();

            primaryStage.setTitle("Calculator");
            primaryStage.getIcons().add(new Image("/image/caculatorv.png"));
            primaryStage.setMinWidth(299);
            primaryStage.setMinHeight(520);
            primaryStage.setScene(new Scene(root, 299, 520));
            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException ioEcx) {
            Logger.getLogger(Calc.class.getName()).log(Level.SEVERE, null, ioEcx);
        }
    }


    public void stop() {

        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }


}
