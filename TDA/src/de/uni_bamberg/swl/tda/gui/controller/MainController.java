package de.uni_bamberg.swl.tda.gui.controller;

import java.io.IOException;

import de.uni_bamberg.swl.tda.gui.model.Model;
import de.uni_bamberg.swl.tda.gui.view.MainView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainController {

	private MainView view;
	private Model model;

	public MainController() {
		try {
			model = new Model();
			view = new MainView(this, model);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startView() {
		this.view.show();
	}

	@FXML // fx:id="dependenciesTab"
	private Tab dependenciesTab; // Value injected by FXMLLoader

	@FXML // fx:id="tableTab"
	private Tab tableTab; // Value injected by FXMLLoader

	@FXML // fx:id="linechartTab"
	private Tab linechartTab; // Value injected by FXMLLoader

	@FXML // fx:id="tabPane"
	private TabPane tabPane; // Value injected by FXMLLoader

	@FXML
	public void loadMenuItemAction(ActionEvent event) {

	}

	@FXML
	public void closeMenuItemAction(ActionEvent event) {

	}

	@FXML
	public void deleteMenuItemAction(ActionEvent event) {

	}

	@FXML
	public void aboutMenuItemAction(ActionEvent event) {

	}
}
