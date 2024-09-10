package com.managestage.managestage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginController.fxml")));

        AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
        AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);

        root.setOnMousePressed(event -> {
            xOffset.set(event.getSceneX());
            yOffset.set(event.getSceneY());
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset.get());
            stage.setY(event.getScreenY() - yOffset.get());
        });

        Scene scene = new Scene(root);

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}