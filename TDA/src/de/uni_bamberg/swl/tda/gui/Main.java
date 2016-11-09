package de.uni_bamberg.swl.tda.gui;

import de.uni_bamberg.swl.tda.gui.controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		new MainController().startView();

	}

}
