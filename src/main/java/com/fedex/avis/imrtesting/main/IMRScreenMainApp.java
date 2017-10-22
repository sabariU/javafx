package com.fedex.avis.imrtesting.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class IMRScreenMainApp extends Application{

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("AVIS Inbound Manifest Review Screen");
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("IMRScreen.fxml"));
			AnchorPane page = (AnchorPane)loader.load();
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.show();
			
//			Properties props = new Properties();
//			props.load(new FileInputStream("IMR.properties"));
//			props.getProperty("os.name");
			
		} catch (IOException e) {
			System.err.println("Error loading IMRScreen.fxml!");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
