package de.uni_bamberg.swl.tda.gui;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Layout extends Application {
	
	//loading the FXML files.
	FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/fxml/mainwindow.fxml"));
	FXMLLoader Tabwindow = new FXMLLoader(getClass().getResource("../resources/fxml/classtab.fxml"));
	FXMLLoader DependenciesPane = new FXMLLoader(getClass().getResource("../resources/fxml/dependencies.fxml"));
	
	
	public static void main(String[] args){
		 Application.launch(Layout.class, (java.lang.String[])null);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
		//initialising the scene.
		AnchorPane page = (AnchorPane) loader.load();
		Scene mainscene = new Scene(page);
		primaryStage.setScene(mainscene);
		primaryStage.setTitle("Testrun Analyzer");
		primaryStage.show();

		}catch (Exception e){
			Logger.getLogger(Layout.class.getName()).log(Level.SEVERE, null, e);
		}		
	}
	
	public Tab getClassTab(){
		try{
			Tab classTab = (Tab) Tabwindow.load();
			return classTab;
			}catch (Exception e){
				Logger.getLogger(Layout.class.getName()).log(Level.SEVERE, null, e);
				return null;
			}		
	}
	
}
