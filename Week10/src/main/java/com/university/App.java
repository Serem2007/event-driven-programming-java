package com.university;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App extends Application {
    private ScheduledExecutorService scheduler;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        primaryStage.setTitle("University Management System");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();

        scheduler = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread thread = new Thread(r, "system-heartbeat");
            thread.setDaemon(true);
            return thread;
        });
        scheduler.scheduleAtFixedRate(
                () -> System.out.println("System Heartbeat: Checking for updates at " + new Date()),
                0, 5, TimeUnit.SECONDS);

        primaryStage.setOnCloseRequest(event -> {
            if (scheduler != null) scheduler.shutdownNow();
        });
    }

    @Override
    public void stop() {
        if (scheduler != null) scheduler.shutdownNow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
