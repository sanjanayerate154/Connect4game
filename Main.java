package com.example.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
	private Controller controller;
	@Override
	public void start(Stage stage) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
		GridPane rootGridPane=loader.load();

		controller=loader.getController();
		controller.createPlayground();

		MenuBar menuBar=createMenu();
		menuBar.prefWidthProperty().bind(stage.widthProperty());

		Pane menuPane= (Pane) rootGridPane.getChildren().get(0);
		menuPane.getChildren().add(menuBar);

		Scene scene=new Scene(rootGridPane);

		stage.setScene(scene);
		stage.setTitle("Connect Four");
		stage.setResizable(false);
		stage.show();
	}

	private MenuBar createMenu()
	{
		//File Menu
		Menu fileMenu=new Menu("File");

		MenuItem newGame=new MenuItem("New game");
		newGame.setOnAction(actionEvent -> controller.resetGame());

		MenuItem resetGame=new MenuItem("Reset game");
		resetGame.setOnAction(actionEvent -> controller.resetGame());

		SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
		MenuItem exitGame=new MenuItem("Exit game");
		exitGame.setOnAction(actionEvent -> exitGame());

		fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);

		//Help Menu
		Menu helpMenu=new Menu("Help");

		MenuItem aboutGame=new MenuItem("About Connect4");
		aboutGame.setOnAction(actionEvent -> aboutConnect4());

		SeparatorMenuItem separator=new SeparatorMenuItem();
		MenuItem aboutMe=new MenuItem("About Me");
		aboutMe.setOnAction(actionEvent -> aboutMe());

		helpMenu.getItems().addAll(aboutGame,separator,aboutMe);

		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);

		return menuBar;
	}

	private void aboutMe()
	{
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "I love to play around with code and create games."+
				" Connect 4 is one of them. In free time "+
				"I like to spend time with near and dears.", ButtonType.OK);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.setHeaderText("Sanjana Yerate");
		alert.setTitle("About The Developer");
		alert.show();
	}

	private void aboutConnect4()
	{
		Alert alert=new Alert(Alert.AlertType.INFORMATION,"Connect Four is a two-player connection game in which the" +
				"players first choose a color and then take turns dropping colored discs " +
				"from the top into a seven-column, six-row vertically suspended grid. " +
				"The pieces fall straight down, occupying the next available space within the column. " +
				"The objective of the game is to be the first to form a horizontal, vertical, " +
				"or diagonal line of four of one's own discs. Connect Four is a solved game. " +
				"The first player can always win by playing the right moves.",ButtonType.OK);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.setTitle("About Connect Four");
		alert.setHeaderText("How to Play?");
		alert.show();

	}

	private void exitGame()
	{
		Platform.exit();
		System.exit(0);
	}

	private void resetGame()
	{


	}

	public static void main(String[] args)
	{
		launch(args);
	}
}