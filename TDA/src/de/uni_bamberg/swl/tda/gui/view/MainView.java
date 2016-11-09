package de.uni_bamberg.swl.tda.gui.view;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import de.uni_bamberg.swl.tda.gui.controller.MainController;
import de.uni_bamberg.swl.tda.gui.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView extends Stage implements Observer {

	private static final String TITLE = "TDA V 1.0";
	private static final String MAINVIEW_FXML_FILE = "/de/uni_bamberg/swl/tda/gui/resources/MainView.fxml";

	private MainController controller;
	private Model model;

	private FXMLLoader mainViewLoader;

	public MainView(MainController controller, Model model) throws IOException {
		this.controller = controller;
		this.model = model;
		model.addObserver(this);

		mainViewLoader = new FXMLLoader();
		mainViewLoader.setLocation(getClass().getResource(MAINVIEW_FXML_FILE));
		mainViewLoader.setController(controller);

		this.setScene(new Scene(mainViewLoader.load()));
		this.setTitle(TITLE);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
