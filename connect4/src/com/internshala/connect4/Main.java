package com.internshala.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();
        controller = loader.getController();
        controller.createPlayground();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    private MenuBar createMenu(){
        Menu filemenu = new Menu("File");
        MenuItem newgame = new MenuItem("New Game");
        newgame.setOnAction(event -> controller.resetGame());

        MenuItem resetgame = new MenuItem("Reset Game");
        resetgame.setOnAction(event -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitgame = new MenuItem("Exit Game");
        exitgame.setOnAction(exent->exitGame());

        filemenu.getItems().addAll(newgame,resetgame,separatorMenuItem,exitgame);

        Menu helpmenu = new Menu("Help");
        MenuItem aboutGame = new MenuItem("About Game");
        aboutGame.setOnAction(event->aboutGame());
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem aboutMe = new MenuItem("About Developer");
        aboutMe.setOnAction(event -> aboutMe());

        helpmenu.getItems().addAll(aboutGame,separator,aboutMe);



        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(filemenu,helpmenu);

        return menuBar;

    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Naveen Gali");
        alert.setContentText("I am learning to code in this LockDown.I created some projects and ConnectFour is on of them");

        alert.show();
    }

    private void aboutGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How To Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column."
                +"six-row vertically suspended grid."+
                "The pieces fall straight down, occupying the next available space within the column."+
                "The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs."+
                "Connect Four is a solved game. The first player can always win by playing the right moves."
        );
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
        //Todo..
    }


    public static void main(String[] args) {
        launch(args);
    }
}
