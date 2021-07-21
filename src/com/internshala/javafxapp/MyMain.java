package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String[] args){
	launch(args);
	}
	@Override
	public void init() throws Exception
	{
		System.out.println("Init");
		super.init();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Start");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();
	}
	private MenuBar createMenu()
	{
		//File Menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(event -> {
			System.out.println("New menu item selected...");
		});

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
		//Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(aboutApp);

		//MenuBar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}

	public static void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My first Desktop app");
		alertDialog.setHeaderText("Learning JavaFx");
		alertDialog.setContentText("I m just a beginner...");
		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();
		if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn)
		{
			System.out.println("Yes Button clicked...");
		}
		else
		{
			System.out.println("No button clicked...");
		}
		alertDialog.showAndWait();
	}

	@Override
	public void stop() throws Exception
	{
		System.out.println("Stop");
		super.stop();
	}

}
